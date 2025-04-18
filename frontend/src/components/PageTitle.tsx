interface PageTitleProps {
  title: string;
}

const PageTitle = ({ title }: PageTitleProps) => {
  return (
    <>  
      <h1 className="text-3xl font-bold mb-6">{title}</h1>
      <hr/>
    </>
  );
};

export default PageTitle;