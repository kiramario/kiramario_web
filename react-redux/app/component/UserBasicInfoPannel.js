import React,{Component} from 'react'

class UserBasicInfoPannel extends Component{
	constructor(props){
		super(props)
		this.handleAvatarClick = this.handleAvatarClick.bind(this)
		console.log(this.props)
	}
	

	handleAvatarClick(){
		alert("will be publish soon")
	}
	
	componentDidUpdate(){
		console.log("UserBasicInfoPannel : componentDidUpdate")
	}
	
	render(){
		let {wxheadImg,wxnickName} = this.props;
		return (
			<ul id="userBasicInfoPannel">
				<li onClick={this.handleAvatarClick}>
					<img className="wxAvatar" src={wxheadImg} />
					<span className="wxNickname">{wxnickName}</span>
				</li>
			</ul>
		);
	}
}

export default UserBasicInfoPannel