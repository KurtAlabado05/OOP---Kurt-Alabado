// kuhain laman ni display
let display = document.getElementById('display');

// kuhain laman ni button(applicable sa lahat ng button)
let buttons = document.querySelectorAll('button');

// calculator object
let calculator = {
  displayValue: '', // current laman ng display
  firstNum: null, // first number na nainput
  secondNum: null, // second number na nainput
  operator: null, // edi operator na ginamit
  isOperatorClicked: false, // kung naclick si op or nah
};

// for each button na addEventListener pag cinlick
buttons.forEach((button) => {
  button.addEventListener('click', (e) => {
    let buttonText = e.target.textContent; // kuhain yung laman na text ng button 
    let buttonId = e.target.id; // kuhain yung id ni button

    // clear button
    if (buttonId === 'clear') {
      calculator.displayValue = '';
      calculator.firstNum = null;
      calculator.secondNum = null;
      calculator.operator = null;
      calculator.isOperatorClicked = false;
      display.value = ''; 
    }
    // equal button
    else if (buttonId === 'equals') {
      if (calculator.firstNum && calculator.operator) {
        // get si secondNum from display
        calculator.secondNum = parseFloat(calculator.displayValue);
        // perform calculation
        let result = calculate(calculator.firstNum, calculator.secondNum, calculator.operator);
        display.value = result; // display result
        calculator.displayValue = result; // update display
        // reset calculator state
        calculator.firstNum = null;
        calculator.secondNum = null;
        calculator.operator = null;
        calculator.isOperatorClicked = false;
      }
    }
    // handle operator buttons 
    else if (buttonId === 'divide' || buttonId === 'multiply' || buttonId === 'subtract' || buttonId === 'add') {
      if (calculator.displayValue !== '') {
        // Get the first number from display
        calculator.firstNum = parseFloat(calculator.displayValue);
        // Set the operator
        calculator.operator = buttonText;
        calculator.displayValue = ''; // Clear the display 
        calculator.isOperatorClicked = true; // Set the operator clicked flag
      }
    } else {
      // Handle number buttons (0-9) and dot
      if (buttonText === '.') {
        if (!calculator.displayValue.includes('.') || calculator.displayValue === '') {
          calculator.displayValue += buttonText;
          display.value = calculator.displayValue;
        }
      } else {
        calculator.displayValue += buttonText;
        display.value = calculator.displayValue;
      }
    }
  });
});

// function para sa operators
function calculate(firstNum, secondNum, operator) {
  switch (operator) {
    case '+':
      return firstNum + secondNum;
    case '-':
      return firstNum - secondNum;
    case '*':
      return firstNum * secondNum;
    case '/':
      return firstNum / secondNum;
    default:
      return 'Error';
  }
}