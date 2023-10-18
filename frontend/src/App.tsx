import React from 'react';
import './App.css';
import {Container} from "react-bootstrap";
import GeneratorForm from "./services/generator-form";
import ValidatorForm from "./services/validator-form";

const paddingTop = '60px';

function App() {

  return (
    <Container className="px-4" style={{ paddingTop }}>
        <div className="container overflow-hidden">
            <div className="row gx-5">
                <div className="col">
                    <div>
                        Generate Token
                    </div>
                   <GeneratorForm/>
                </div>
                <div className="col">
                    <div>
                        Validate token
                    </div>
                    <ValidatorForm/>
                </div>
            </div>
        </div>

    </Container>
  );
}

export default App;