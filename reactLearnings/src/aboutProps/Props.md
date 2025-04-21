
#About Properties
Props are the properties stored on Global scope.
you can pass props to pass values from parent to
child inorder to communicate.

Props can't be modified and stateless compared to state 


###Define global properties of Parent

`Parent.defaultProps= {
cars : ["Baleno", "WagonR","Honda","Mahindra"]

}`

###parent component

 ` <Car msg="Msg from Parent : Hi my cars" showCars={this.props.cars}/>
`
###child component

`  <p> {this.props.msg}</p>
                <p>{this.props.showCars.map(
                    (item, i) => {
                        return <p>  {i + 1} . {item} </p>
                    }
                )
                } </p>`
--------------------------

###Defining type of variable

`Parent.propTypes ={

propObject : React.PropTypes.object,
propString : React.PropTypes.string,
propNumber : React.PropTypes.number

}`

providing value to them .

Parent.defaultProps = {
`cars: ["Baleno", "WagonR", "Honda", "Mahindra"],
propString :"Excellent Motors",
propNumber : "Rating : Number one",
propObject :{
obj1 : "I am obj1",
obj2 : "I am obj2"
}
}`

using it inside parent class
`<h2>{this.props.propString} </h2>
<h2>{this.props.propNumber} </h2>
<h2>{this.props.propObject.obj1} </h2>`


#Defining State 

`constructor(props) {
super(props);
this.flag=true;
this.state = {
cars:this.props.carsS
};
this.removeState= this.removeState.bind(this);
}`


accessing State

`  <Car msg="Msg from Parent : Hi my cars" showCars={this.state.cars}/>`

