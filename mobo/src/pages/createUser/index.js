import React, { Component } from "react";
import {
  View,
  Text,
  Image,
  TextInput,
  TouchableOpacity,
  ImageBackground
} from "react-native";
import api from "../../services/api";
import AsyncStorage from "@react-native-community/async-storage";
import background from "../../assets/back.png";
import styles from "./styles";
import logo from "../../assets/logo.png";

export default class CreateUser extends Component {
  state = {
    email: "",
    password: "",
    confirmation: "",
    usuario: ""
  };

  componentDidMount() {
    // this._retrieveData();
  }

  _retrieveData = async () => {
    try {
      const value = await AsyncStorage.getItem("@easylist:id");
      if (value !== null) {
        this.props.navigation.navigate("Lists");
      }
    } catch (error) {}
  };

  _storeData = async id => {
    try {
      await AsyncStorage.setItem("@easylist:id", `${id}`);
    } catch (error) {
      // Error saving data
    }
  };

  render() {
    return (
      <ImageBackground
        source={background}
        style={{ width: "100%", height: "100%" }}
      >
        <View style={styles.contrainer}>
          <View style={styles.logo}>
            <Image style={styles.logoImg} source={logo} />
          </View>
          <View style={styles.cad}>
            <Text style={styles.cadText}>Cadastrar</Text>
          </View>
          <View style={styles.form}>
            <View style={styles.row}>
              <Text style={styles.rowText}>Email</Text>
              <TextInput
                style={styles.inputEmail}
                autoCapitalize="none"
                autoCorrect={false}
                underlineColorAndroid="transparent"
                value={this.state.email}
                onChangeText={text => this.setState({ email: text })}
              />
            </View>

            <View style={styles.row}>
              <Text style={styles.rowText}>Usuario</Text>
              <TextInput
                style={styles.inputUser}
                autoCapitalize="none"
                autoCorrect={false}
                underlineColorAndroid="transparent"
                value={this.state.usuario}
                onChangeText={text => this.setState({ usuario: text })}
              />
            </View>
            <View style={styles.division}>
              <View style={styles.row}>
                <Text style={styles.rowText}>Senha</Text>
                <TextInput
                  style={styles.inputPassword}
                  autoCapitalize="none"
                  autoCorrect={false}
                  underlineColorAndroid="transparent"
                  value={this.state.password}
                  secureTextEntry={true}
                  onChangeText={text => this.setState({ password: text })}
                />
              </View>

              <View style={styles.row}>
                <Text style={styles.rowText}>Confirme a Senha</Text>
                <TextInput
                  style={styles.inputConfirmation}
                  autoCapitalize="none"
                  autoCorrect={false}
                  underlineColorAndroid="transparent"
                  value={this.state.confirmation}
                  secureTextEntry={true}
                  onChangeText={text => this.setState({ confirmation: text })}
                />
              </View>
            </View>
          </View>
          <View style={styles.footer}>
            <TouchableOpacity
              onPress={() => this.props.navigation.navigate("Login")}
              style={styles.btnCad}
            >
              <Text style={styles.btnCadText}>Cadastrar</Text>
            </TouchableOpacity>
            <TouchableOpacity
              onPress={() => this.props.navigation.navigate("Login")}
              style={styles.btnCance}
            >
              <Text style={styles.btnCanceText}>Cancelar</Text>
            </TouchableOpacity>
          </View>
        </View>
      </ImageBackground>
    );
  }
}
