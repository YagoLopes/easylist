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
    width: "100%"
  },
  cadText: {
    color: "#115B74",
    alignSelf: "center"
  },
  rowText: {
    color: "#fff",
    marginTop: 10
  },

  division: {
    flexDirection: "row",
    justifyContent: "space-between"
  },

  inputEmail: {
    backgroundColor: "#fff",
    borderRadius: 10,
    height: 28,
    marginTop: 8
  },
  inputPassword: {
    backgroundColor: "#fff",
    borderRadius: 10,
    height: 28,
    marginTop: 8,
    width: 130
  },
  inputConfirmation: {
    backgroundColor: "#fff",
    borderRadius: 10,
    height: 28,
    marginTop: 8,
    width: 130
  },
  inputUser: {
    backgroundColor: "#fff",
    borderRadius: 10,
    height: 28,
    marginTop: 8
  },

  submitText: {},
  form: {
    // backgroundColor: "#000",
    paddingHorizontal: 30,
    marginBottom: 50,
    paddingBottom: 30
  },
  footer: {
    height: 95,

    backgroundColor: "#115B74",
    width: "100%",
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    paddingHorizontal: 30
  },
  footerText: {
    color: "#fff",
    marginTop: 10
  },

  btnCad: {
    height: 35,
    fontSize: 16,
    paddingHorizontal: 30,
    justifyContent: "center",
    alignItems: "center",
    borderRadius: 20,
    borderWidth: 2,
    borderColor: "#fff"
  },
  btnCadText: {
    fontSize: 16,
    color: "#fff"
  },
  btnCance: {
    height: 40,
    fontSize: 16,
    paddingHorizontal: 30,
    justifyContent: "center",
    alignItems: "center"
  },
  btnCanceText: {
    fontSize: 16,
    color: "#E49600"
  }
});

export default styeles;
