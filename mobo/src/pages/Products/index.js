import React, { Component } from "react";
import api from "../../services/api";
import AsyncStorage from "@react-native-community/async-storage";

import { View, Text, TouchableOpacity, ScrollView } from "react-native";
import Icon from "react-native-vector-icons/FontAwesome";
import styles from "./styles";

export default class Products extends Component {
  state = {
    produtos: []
  };
  componentDidMount() {
    this._PushID();
  }
  _PushID = async () => {
    const id = await AsyncStorage.getItem("@easylist:LID");
    this._PushLists(id);
  };
  _PushLists = async id => {
    try {
      const response = await api.get(`/prodlists/${id}`);
      this.setState({ produtos: response.data });
    } catch (err) {}
  };

  /* handleSignIn = async () => {
    await this.props.navigation.navigate("Products");
  };
  */
  handleAddLista = async () => {
    await this.props.navigation.navigate("AddProducts");
  };

  renderLists = () =>
    this.state.produtos.map(produto => (
      <TouchableOpacity
        key={produto.id}
        onPress={() => {}}
        style={styles.lista}
      >
        <View style={styles.butons}>
          <TouchableOpacity style={styles.btnMinus} onPress={() => {}}>
            <Icon name="minus" style={styles.iconMinus} />
          </TouchableOpacity>
          <TouchableOpacity style={styles.btnCircle} onPress={() => {}}>
            <Icon name="circle" style={styles.iconCircle} />
          </TouchableOpacity>
        </View>
        <View style={styles.group}>
          <Text style={styles.listaTitulo}>{produto.nome}</Text>
          <View style={styles.info}>
            <View style={styles.valor}>
              <Text style={styles.infoValor}>Valor: </Text>
              <Text style={styles.valorData}>R${produto.valor}</Text>
            </View>
            <View style={styles.valor}>
              <Text style={styles.infoValor}>Mercado: </Text>
              <Text style={styles.valorData}>{produto.mercado}</Text>
            </View>
            <View style={styles.valor}>
              <Text style={styles.infoValor}>Descrição: </Text>
              <Text style={styles.valorData}>{produto.descricao}</Text>
            </View>
          </View>
        </View>
      </TouchableOpacity>
    ));

  render() {
    return (
      <View style={styles.contrainer}>
        <View style={styles.nav}>
          <Text style={styles.titulo}>Lista Tejotão</Text>
        </View>
        <ScrollView
          keyboardShouldPersistTraps="never"
          ref={scrollView => (this.scrollView = scrollView)}
          contentContainerStyle={styles.conversation}
        >
          {this.renderLists()}
        </ScrollView>
        <View style={styles.footer}>
          <TouchableOpacity
            onPress={() => this.props.navigation.navigate("AddProducts")}
            style={styles.btnCad}
          >
            <Text style={styles.btnCadText}>Cadastrar</Text>
          </TouchableOpacity>
          <TouchableOpacity
            onPress={() => this.props.navigation.navigate("Lists")}
            style={styles.btnCance}
          >
            <Text style={styles.btnCanceText}>Voltar</Text>
          </TouchableOpacity>
        </View>
      </View>
    );
  }
}
