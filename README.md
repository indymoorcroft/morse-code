# 🔠 Morse Code Translator (Scala CLI)

A simple, functional Scala command-line application that translates between **English text** and **Morse code** — and vice versa. Supports auto-detection of input type, helpful error messages, and looping until the user types `#` to exit.

---

## 🚀 Features

- 🔄 **Bidirectional translation**: English → Morse, Morse → English
- 🧠 **Auto-detect input type**
- 🔁 **Looping prompt** until the user exits
- 🧼 **Validation** with helpful error feedback
- ❌ Invalid characters are shown all at once
- 🧪 **Tested with ScalaTest**
- 💡 Written in a functional style with pure logic and immutable data

---

## 🧰 How It Works

### 📘 English to Morse
- Characters are converted one by one
- Invalid characters are listed clearly
- Spaces between Morse letters, `/` between words

### 🆎 Morse to English
- Auto-detects Morse format by checking for `.`, `-`, `/`
- Letters are separated by spaces, words by `/`

---

## ✅ Run It

### 🎯 Requirements
- Scala 2.13+ or Scala 3
- sbt (Scala Build Tool)

### 🏃🏻‍♂️‍➡️ Run the app
- sbt run (to start program)
- sbt test (to run tests)

---

## 🧪 Testing Coverage

###Tested features:
- English → Morse
- Morse → English
- Word separation and spacing
- Auto-detection logic
- Invalid character handling
- Looping logic

Tests are written using ScalaTest and kept pure for maximum reliability.


Pull requests are welcome!
