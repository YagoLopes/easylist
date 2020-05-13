import React, { Component } from "react";
import { View, Text, TextInput, TouchableOpacity } from "react-native";
import AsyncStorage from "@react-native-community/async-storage";
import Icon from "react-native-vector-icons/dist/FontAwesome";
import api from "../../services/api";

import styles from "./styles";

export default class AddProducts extends Component {
  state = {
    nome: "",
    valor: "",
    mercado: "",
    descricao: "",
    comprovante: "",
    listaID: ""
  };
  componentDidMount() {
    this._PushID();
  }
  _PushID = async () => {
    const id = await AsyncStorage.getItem("@easylist:LID");
    this.setState({ listaID: id });
  };
  handleSignIn = async () => {
    const {
      nome,
      valor,
      mercado,
      descricao,
      comprovante,
      listaID
    } = this.state;

    try {
      await api.post("/produto", {
        nome,
        valor,
        mercado,
        descricao,
        comprovante,
        listaID
      });

      this.props.navigation.navigate("Products");
    } catch (err) {}
  };

  render() {
    return (
      <View style={styles.contrainer}>
        <Icon name="clipboard" style={styles.icon} />
        <TextInput
          style={styles.input}
          placeholder="Nome"
          placeholderTextColor="#999"
          autoCapitalize="none"
          autoCorrect={false}
          underlineColorAndroid="transparent"
          value={this.state.nome}
          onChangeText={text => this.setState({ nome: text })}
        />
        <TextInput
          style={styles.input}
          placeholder="Valor"
          placeholderTextColor="#999"
          autoCapitalize="none"
          autoCorrect={false}
          underlineColorAndroid="transparent"
          value={this.state.valor}
          onChangeText={text => this.setState({ valor: text })}
        />
        <TextInput
          style={styles.input}
          placeholder="Mercado"
          placeholderTextColor="#999"
          autoCapitalize="none"
          autoCorrect={false}
          underlineColorAndroid="transparent"
          value={this.state.mercado}
          onChangeText={text => this.setState({ mercado: text })}
        />
        <TextInput
          style={styles.input}
          placeholder="Descrição"
          placeholderTextColor="#999"
          autoCapitalize="none"
          autoCorrect={false}
          underlineColorAndroid="transparent"
          value={this.state.descricao}
          onChangeText={text => this.setState({ descricao: text })}
        />
        <TextInput
          style={styles.input}
          placeholder="Comprovante"
          placeholderTextColor="#999"
          autoCapitalize="none"
          autoCorrect={false}
          underlineColorAndroid="transparent"
          value={this.state.comprovante}
          onChangeText={text => this.setState({ comprovante: text })}
        />
        <TouchableOpacity onPress={this.handleSignIn} style={styles.button}>
          <Text style={styles.buttonText}>Criar</Text>
        </TouchableOpacity>
      </View>
    );
  }
}
