import {SubmitHandler, useForm} from "react-hook-form";

import React, {useState} from "react";
import {Card, CardBody, CardFooter} from "react-bootstrap";
import {TokenValidatorService, ValidateTokenRequest} from "./validator";


export default function ValidatorForm() {
    const { register, handleSubmit } = useForm<ValidateTokenRequest>();
    const [message , setMessage]: [string, (message: string) => void] = useState<string>('');
    const [error , setError]: [string, (error: string) => void] = useState<string>('');
    const onSubmit: SubmitHandler<ValidateTokenRequest> = data =>{
        TokenValidatorService.validate(data)
            .then(response => {
                if(response != null && response.message != null) {
                    setMessage(response.message)
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
                            <input {...register("token")} placeholder='Token to be validated' className='form-control'/>
                        </div>

                        <div className="form-group">
                            <input type="submit" value="validate" />
                        </div>

                    </form>
                </CardBody>
                {
                    message ?
                        <CardFooter>
                            <div>
                                {message}
                            </div>
                            <div>
                                {error}
                            </div>
                        </CardFooter>
                        : null
                }
            </Card>
        </>
    )
}
