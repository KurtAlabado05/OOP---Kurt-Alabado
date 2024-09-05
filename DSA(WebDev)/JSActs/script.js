
let display = document.getElementById('display');
let buttons = document.querySelectorAll('button');

let calculator = {
  displayValue: '',
  firstOperand: null,
  secondOperand: null,
  operator: null,
  isOperatorClicked: false,
};

buttons.forEach((button) => {
    button.addEventListener('click', (e) => {
      let buttonText = e.target.textContent;
      let buttonId = e.target.id;

    if (buttonId === 'clear') {
      calculator.displayValue = '';
      calculator.firstOperand = null;
      calculator.secondOperand = null;
      calculator.operator = null;
      calculator.isOperatorClicked = false;
      display.value = '';
    } else if (buttonId === 'equals') {
      if (calculator.firstOperand && calculator.operator) {
        calculator.secondOperand = parseFloat(calculator.displayValue);
        let result = calculate(calculator.firstOperand, calculator.secondOperand, calculator.operator);
        display.value = result;
        calculator.displayValue = result;
        calculator.firstOperand = null;
        calculator.secondOperand = null;
        calculator.operator = null;
        calculator.isOperatorClicked = false;
      }
    } else if (buttonId === 'divide' || buttonId === 'multiply' || buttonId === 'subtract' || buttonId === 'add') {
      if (calculator.displayValue !== '') {
        calculator.firstOperand = parseFloat(calculator.displayValue);
        calculator.operator = buttonText;
        calculator.displayValue = '';
        calculator.isOperatorClicked = true;
      }
    } else {
        if (calculator.isOperatorClicked) {
          calculator.displayValue = ''; // Clear the display value
          calculator.isOperatorClicked = false;
        }
        calculator.displayValue += buttonText;
        display.value = calculator.displayValue;
      }
    });
  });

function calculate(firstOperand, secondOperand, operator) {
  switch (operator) {
    case '+':
      return firstOperand + secondOperand;
    case '-':
      return firstOperand - secondOperand;
    case '*':
      return firstOperand * secondOperand;
    case '/':
      return firstOperand / secondOperand;
    default:
      return 'Error';
  }
}