// src/pages/UserList.tsx
import { useEffect, useState } from 'react'
import { getPaginatedUsers } from '@/services/userService';
import { useNavigate } from 'react-router-dom';
import { User } from '@/types/User';
import PageContent from '@/components/PageContent';
import PageTitle from '@/components/PageTitle';

export default function UserList() {
  const [users, setUsers] = useState<User[]>([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const navigate = useNavigate();

  useEffect(() => {
    getPaginatedUsers(page).then((data) => {
      setUsers(data.content);
      setTotalPages(data.totalPages);
    });
  }, [page]);

  return (
        <PageContent>
        <PageTitle title="User List" />
        <div className="flex justify-between items-center mt-4" style={{ marginBottom: '20px' }}> 
        <button
            onClick={() => navigate('/users/create')}
            className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
          >
            + Create User
          </button>  
          </div> 
        <div className="overflow-x-auto rounded-lg shadow-md">
          <table className="w-full border-collapse  dark:bg-gray-800">
            <thead>
              <tr className="bg-gray-200 dark:bg-gray-700 text-left">
                <th className="p-4">ID</th>
                <th className="p-4">Name</th>
                <th className="p-4">Email</th>
                <th className="p-4">Status</th> {/* <- aqui também */}
              </tr>
            </thead>
            <tbody>
              {users.map(user => (
                <tr
                  key={user.id}
                  className="border-b border-gray-200 dark:border-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600"
                >
                  <td className="p-4">{user.id}</td>
                  <td className="p-4">{user.name}</td>
                  <td className="p-4">{user.email}</td>
                  <td className="p-4">{user.status}</td> {/* <- e aqui */}
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        <div className="flex justify-center gap-2 mt-6">
          {Array.from({ length: totalPages }, (_, i) => (
            <button
              key={i}
              onClick={() => setPage(i)}
              className={`px-4 py-2 rounded ${
                i === page
                  ? 'bg-blue-600 text-white'
                  : 'bg-gray-200 dark:bg-gray-700 text-gray-900 dark:text-gray-100'
              }`}
            >
              {i + 1}
            </button>
          ))}
        </div>
        </PageContent>
  );
}
