import { Component } from "react";
import { connect } from "react-redux";

class ProductC1 extends Component {
  render() {
    return (
      <div className="customDiv">
        <h2>Purchase Component</h2>
        {/* // invoke purchaseHandler through props */}
        <select onChange={(e) => this.props.purchaseHandler(e)}>
          {this.props.products.map((product, index) => {
            return (
              <option value={product.price} key={index}>
                {product.pName}-{product.price}
              </option>
            );
          })}
        </select>

        <hr />
      </div>
    );
  }
}

// THis is map Store state to products inside props
// This will invoke everytime when store state is updated
const mapStateToProps = (state) => {
  return {
    products: state.products,
  };
};

// This will retrun dispatch object . also called action creater and called asys
const actionPurchase = (e) => {
  let pName = e.target.options[e.target.selectedIndex].text;
  let price = e.target.value;
  let obj = { pName, price };
  // it return a dispatch object
  return { type: "PURCHASE", payload: obj };
};

// this will map Dipatch Action when you change drop down selection
const mapDispatchToProps = (dispatch) => {
  return {
    purchaseHandler: (e) => dispatch(actionPurchase(e)),
  };
};

// Connect is main hook which will map  state, action and product class 
export default connect(mapStateToProps, mapDispatchToProps)(ProductC1);
