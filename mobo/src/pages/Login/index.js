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

export default class Login extends Component {
  state = {
    email: "",
    password: ""
  };

  componentDidMount() {
    this._retrieveData();
  }

  _retrieveData = async () => {
    try {
      const value = await AsyncStorage.getItem("@easylist:id");
      if (value !== null) {
        this.props.navigation.navigate("Lists");
      }
    } catch (error) {}
  };

  handleSignIn = async () => {
    const { email, password } = this.state;
    try {
      const response = await api.get(
        `/usuario?email=${email}&password=${password}`
      );
      const id = response.data.id;
      this._storeData(id);
      this.props.navigation.navigate("Lists");
    } catch (err) {}
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
            <TouchableOpacity
              onPress={() => this.props.navigation.navigate("CreateUser")}
              style={styles.cadBtn}
            >
              <Text style={styles.cadBtnText}>Cadastrar</Text>
            </TouchableOpacity>
          </View>
          <View style={styles.form}>
            <TextInput
              style={styles.inputEmail}
              placeholder="Usuário ou e-mail"
              autoCapitalize="none"
              placeholderTextColor="#fff"
              autoCorrect={false}
              underlineColorAndroid="transparent"
              value={this.state.email}
              onChangeText={text => this.setState({ email: text })}
            />
            <TextInput
              style={styles.inputPassword}
              placeholder="Senha"
              placeholderTextColor="#fff"
              autoCapitalize="none"
              autoCorrect={false}
              underlineColorAndroid="transparent"
              value={this.state.password}
              secureTextEntry={true}
              onChangeText={text => this.setState({ password: text })}
            />
            <View style={styles.footer}>
              <TouchableOpacity
                onPress={this.handleSignIn}
                style={styles.submit}
              >
                <Text style={styles.submitText}>ENTRAR</Text>
              </TouchableOpacity>
              <Text style={styles.footerText}>Esqueceu sua senha?</Text>
            </View>
          </View>
        </View>
      </ImageBackground>
    );
  }
}
