import {SubmitHandler, useForm} from "react-hook-form";

import {GenerateTokenRequest, TokenGeneratorService} from "./generator";
import React, {useState} from "react";
import {Card, CardBody, CardFooter} from "react-bootstrap";


export default function GeneratorForm() {
    const { register, handleSubmit } = useForm<GenerateTokenRequest>();
    const [token , setToken]: [string, (token: string) => void] = useState<string>('');
    const [error , setError]: [string, (error: string) => void] = useState<string>('');

    const onSubmit: SubmitHandler<GenerateTokenRequest> = data =>{
        TokenGeneratorService.generate(data)
            .then(response => {
                if(response.token){
                    setToken(response.token)
                }
            })
            .catch(error => {
                setError(error)
            })
    }

    return (
        <>
            <Card>
                <CardBody>
                    <form onSubmit={handleSubmit(onSubmit)}>
                        <div className="form-group">
                            <input {...register("digits")} placeholder='Input token digits' className='form-control'/>
                        </div>

                        <div className="form-group">
                            <input type="submit" value="generate"/>
                        </div>
                    </form>
                </CardBody>
                {
                    token ?
                    <CardFooter>
                        <div>
                            Copy token to validate: <strong>{token}</strong>
                        </div>
                    </CardFooter>
                    : null
                }
            </Card>
        </>
    )
}
