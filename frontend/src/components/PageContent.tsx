interface PageContentProps {
  children: React.ReactNode;
}

const PageContent = ({ children }: PageContentProps) => {
  return (
    <main className="min-h-screen dark:bg-gray-900 text-gray-900 dark:text-gray-100 p-6">
      <div className="max-w-6xl mx-auto">
        {children}
      </div>
    </main>
  );
};

export default PageContent;