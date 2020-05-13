import { StyleSheet } from "react-native";

const styeles = StyleSheet.create({
  contrainer: {
    flex: 1,
    justifyContent: "space-between"
  },
  logoImg: {
    marginTop: 30,
    width: 150,
    height: 150,
    alignSelf: "center"
  },

  cad: {
    width: "100%",
    backgroundColor: "#E49600"
  },
  cadBtnText: {
    color: "#0B8402",
    alignSelf: "center"
  },

  inputEmail: {
    color: "#fff",
    borderBottomWidth: 1,
    borderBottomColor: "#fff",
    height: 48,
    fontSize: 16,
    paddingHorizontal: -20,
    marginTop: 30
  },
  inputPassword: {
    color: "#fff",
    borderBottomWidth: 1,
    borderBottomColor: "#fff",
    height: 48,
    fontSize: 16,
    paddingHorizontal: -20,
    marginTop: 10
  },

  submit: {
    height: 40,
    borderRadius: 20,
    fontSize: 16,
    paddingHorizontal: 30,
    marginTop: 30,
    backgroundColor: "#E49600",
    justifyContent: "center",
    alignItems: "center"
  },

  submitText: {
    fontSize: 16,
    color: "#fff"
  },
  form: {
    // backgroundColor: "#000",
    paddingHorizontal: 30,
    marginBottom: 50,
    paddingBottom: 30
  },
  footer: {
    alignSelf: "center"
  },
  footerText: {
    color: "#fff",
    marginTop: 10
  }
});

export default styeles;
