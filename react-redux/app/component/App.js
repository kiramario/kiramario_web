import React,{Component} from 'react'
import UserBasicInfoPannelConn from "../connector/UserBasicInfoPannelConn"


class App extends Component{
	constructor(props){
		super(props)
	}
	
	
	
	render(){
		return (
			<div id="" className="hei_100">
				<UserBasicInfoPannelConn />
			</div>
		);
	}
}


export default App