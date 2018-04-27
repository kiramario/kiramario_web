import { connect } from 'react-redux'
import UserBasicInfoPannel from "../component/UserBasicInfoPannel"


const mapStateToProps = (state, ownProps) => {
	return {
		wxheadImg:state.userInfo.wxheadImg,
		wxnickName:state.userInfo.wxnickName
	}
};

const mapDispatchToProps = (dispatch,ownProps) => {
	return {
		
	}
};



const UserBasicInfoPannelConn = connect(
	mapStateToProps,
	mapDispatchToProps
)(UserBasicInfoPannel);

export default UserBasicInfoPannelConn;