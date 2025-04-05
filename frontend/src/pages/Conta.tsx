interface ContaProps {
    user: {
      name: string;
      email: string;
      picture: string;
    };
  }
  
  const Conta = ({ user }: ContaProps) => {
    return (
      <div>
        <h2>Minha Conta</h2>
        <p>Nome: {user.name}</p>
        <p>Email: {user.email}</p>
        <img src={user.picture} alt="Avatar" style={{ borderRadius: '50%', width: 100 }} />
      </div>
    );
  };
  
  export default Conta;