import React, { Component } from "react";
import api from "../../services/api";
import AsyncStorage from "@react-native-community/async-storage";

import { View, Text, TouchableOpacity, ScrollView } from "react-native";
import Icon from "react-native-vector-icons/FontAwesome";
import styles from "./styles";
import styeles from "./styles";

export default class Lists extends Component {
  state = {
    listas: []
  };

  componentDidMount() {
    this._PushID();
  }
  _PushID = async () => {
    const id = await AsyncStorage.getItem("@easylist:id");

    this._PushLists(id);
  };
  _PushLists = async id => {
    try {
      const response = await api.get(`/userlists/${id}`);
      this.setState({ listas: response.data });
    } catch (err) {}
  };

  _storeData = async id => {
    try {
      await AsyncStorage.setItem("@easylist:LID", `${id}`);
    } catch (error) {
      // Error saving data
    }
  };
  removeItem = async id => {
    try {
      await api.delete(`/lista/${id}`);
    } catch (err) {}
  };

  handleSignIn = async id => {
    this._storeData(id);
    await this.props.navigation.navigate("Products");
  };
  handleLogout = async () => {
    await AsyncStorage.removeItem("@easylist:id");
    await AsyncStorage.removeItem("@easylist:LID");
    this.props.navigation.navigate("Login");
  };
  handleAddLista = async () => {
    await this.props.navigation.navigate("AddList");
  };

  renderLists = () =>
    this.state.listas.map(lista => (
      <TouchableOpacity
        key={lista.id}
        onPress={() => this.handleSignIn(lista.id)}
        style={styles.lista}
      >
        <Text style={styles.nameList}>{lista.nome}</Text>
        <View style={styles.group}>
          <View style={styles.butons}>
            <TouchableOpacity
              style={styles.btnTrash}
              onPress={() => this.removeItem(lista.id)}
            >
              <Icon name="trash" style={styles.iconTrash} />
            </TouchableOpacity>
            <TouchableOpacity
              style={styles.btnTools}
              onPress={() => this.editItem(lista.id)}
            >
              <Icon name="cog" style={styles.iconTools} />
            </TouchableOpacity>
          </View>
        </View>
      </TouchableOpacity>
    ));

  render() {
    return (
      <View style={styles.contrainer}>
        <View style={styles.nav}>
          <Text style={styles.titulo}>Minhas Listas</Text>
          <TouchableOpacity onPress={this.handleLogout} style={styles.sair}>
            <Text style={styeles.sairText}>Sair</Text>
          </TouchableOpacity>
        </View>
        <ScrollView
          keyboardShouldPersistTraps="never"
          ref={scrollView => (this.scrollView = scrollView)}
          contentContainerStyle={styles.conversation}
        >
          {this.renderLists()}
        </ScrollView>
        <View style={styles.footer}>
          <TouchableOpacity onPress={this.handleAddLista} style={styles.add}>
            <Icon name="plus" style={styles.icon} />
          </TouchableOpacity>
        </View>
      </View>
    );
  }
}
