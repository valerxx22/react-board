import React, {Component} from 'react';
import {Link, withRouter} from 'react-router';
import client from '../services/client';
import ValidationForm from '../services/validation-form';

class ProjectForm extends Component {

    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.validate = this.validate.bind(this);
        this.state = {
            data: {name: "", key: "", description: ""},
            constraints: [],
            edit: false
        }
    }

    componentWillMount() {
        if (this.props.params.projectId) {
            client({method: 'GET', path: this.props.apiUrl.project + '/' + this.props.params.projectId}).then(response => {
                if (response.status.code == 200) {
                    this.setState({data: response.entity, edit: true});
                }
            });
        }
        client({method: 'GET', path: this.props.apiUrl.constraints}).then(response => {
            if (response.status.code == 200) {
                this.setState({constraints: response.entity});
            }
        });
    }

    save() {
        if (this.state.edit) {
            client({method: 'PUT', path: this.props.apiUrl.project, entity: this.state.data}).then(response => {
                if (response.status.code == 200) {
                    this.props.router.push('admin/projects');
                }
            });
        } else {
            client({method: 'POST', path: this.props.apiUrl.project, entity: this.state.data}).then(response => {
                if (response.status.code == 201) {
                    this.props.router.push('admin/projects');
                }
            });
        }
    }

    validate() {
        if(ValidationForm.validate(this.state.constraints, this.refs)){
            this.save();
        }
    }

    handleChange(e) {
        this.state.data[e.target.name] = e.target.value;
        var generatedVal = '';
        if (e.target.name == 'name') {
            var arr = e.target.value.split(" ");
            if (arr.length > 1) {
                for (var i = 0; i < arr.length; i++) {
                    var uppercaseletters = '';
                    for (var j = 1; j < arr[i].length; j++) {
                        if (arr[i].charAt(j) == arr[i].charAt(j).toUpperCase()) {
                            uppercaseletters += arr[i].charAt(j);
                        }
                    }
                    generatedVal += (arr[i].charAt(0).toUpperCase() + uppercaseletters);
                }
            } else {
                generatedVal = arr[0].toUpperCase();
            }
            if (generatedVal.indexOf(this.state.data.key) == 0 || this.state.data.key == '' || this.state.data.key == arr[0].toUpperCase()) {
                this.state.data.key = generatedVal;
            }
        }
        if(e.target.name == 'key'){
            this.state.data.key = e.target.value.toUpperCase();
        }
        this.setState({data: this.state.data});
    }

    render() {
        return (
            <form className="form-horizontal">
                <div className="main-project-form col-md-8">
                    <div className="form-group has-feedback">
                        <label htmlFor="inputName" className="col-sm-2 control-label">Name</label>
                        <div className="col-sm-10">
                            <input name="name" ref="name" type="text" className="form-control" classID="inputName"
                                   placeholder="Name"
                                   value={this.state.data.name} onChange={this.handleChange}/>
                            <p className="help-block"> </p>
                        </div>
                    </div>
                    <div className="form-group">
                        <label htmlFor="inputKey" className="col-sm-2 control-label">Key</label>
                        <div className="col-sm-10">
                            <input name="key" ref="key" type="text" className="form-control" classID="inputKey" placeholder="Key"
                                   value={this.state.data.key} onChange={this.handleChange}/>
                            <p className="help-block"> </p>
                        </div>
                    </div>
                    <div className="form-group">
                        <label htmlFor="inputDesc" className="col-sm-2 control-label">Description</label>
                        <div className="col-sm-10">
                            <textarea name="description" ref="description" className="form-control" rows="3" classID="inputDesc"
                                  placeholder="Description" value={this.state.data.description}
                                  onChange={this.handleChange}/>
                            <p className="help-block"> </p>
                        </div>
                    </div>
                    <div ref="formMessages" className="clearfix  col-md-12"></div>
                    <div className="form-group">
                        <div className="col-sm-offset-2 col-sm-10 btn-group">
                            <a className="btn btn-primary" role="button" onClick={this.validate}>Save</a>
                            <Link to={'admin/projects'} className="btn btn-danger" role="button">Cancel</Link>
                        </div>
                    </div>
                </div>

            </form>
        )
    }
}

export default withRouter(ProjectForm)
ProjectForm.defaultProps = {apiUrl: {project: '/api/projects', constraints: '/api/constraints/project'}};
