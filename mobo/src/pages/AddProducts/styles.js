import { StyleSheet } from "react-native";

const styeles = StyleSheet.create({
  contrainer: {
    flex: 1,
    justifyContent: "center",
    alignItems: "stretch",
    paddingHorizontal: 30
  },

  icon: {
    fontSize: 120,
    color: "#900",
    alignSelf: "center"
  },

  input: {
    height: 48,
    borderWidth: 1,
    borderColor: "#DDD",
    borderRadius: 4,
    fontSize: 16,
    paddingHorizontal: 20,
    marginTop: 30
  },

  button: {
    height: 48,
    borderRadius: 4,
    fontSize: 16,
    paddingHorizontal: 20,
    marginTop: 10,
    backgroundColor: "#115B74",
    justifyContent: "center",
    alignItems: "center"
  },

  buttonText: {
    fontWeight: "bold",
    fontSize: 16,
    color: "#fff"
  }
});

export default styeles;
