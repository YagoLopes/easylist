import React, { Component } from "react";
import { View, Text, TextInput, TouchableOpacity } from "react-native";
import AsyncStorage from "@react-native-community/async-storage";
import Icon from "react-native-vector-icons/dist/FontAwesome";
import api from "../../services/api";

import styles from "./styles";

export default class AddList extends Component {
  state = {
    newList: "",
    id: ""
  };
  componentDidMount() {
    this._PushID();
  }
  _PushID = async () => {
    const id = await AsyncStorage.getItem("@easylist:id");
    this.setState({ id });
  };
  handleSignIn = async () => {
    const usuarioID = this.state.id;
    const nome = this.state.newList;
    try {
      await api.post("/lista", { nome, usuarioID });
      this.props.navigation.navigate("Lists");
    } catch (err) {}
  };

  render() {
    return (
      <View style={styles.contrainer}>
        <Icon name="clipboard" style={styles.icon} />
        <TextInput
          style={styles.input}
          placeholder="Crie uma lista"
          placeholderTextColor="#999"
          autoCapitalize="none"
          autoCorrect={false}
          underlineColorAndroid="transparent"
          value={this.state.newList}
          onChangeText={text => this.setState({ newList: text })}
        />

        <TouchableOpacity onPress={this.handleSignIn} style={styles.button}>
          <Text style={styles.buttonText}>Criar</Text>
        </TouchableOpacity>
      </View>
    );
  }
}
