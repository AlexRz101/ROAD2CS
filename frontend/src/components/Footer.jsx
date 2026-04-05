export default function Footer() {
    return (
        <footer className="w-full bg-black text-white py-4">
            <div className="px-2 md:px-8 flex justify-between items-center">
                <div className="text-Montserrat">
                    {/* Mobile: two lines */}
                    <div className="md:hidden">
                        <div>© {new Date().getFullYear()} California State</div>
                        <div>University Northridge</div>
                    </div>
                    {/* Desktop: one line */}
                    <div className="hidden md:block">
                        © {new Date().getFullYear()} California State University Northridge
                    </div>
                </div>
                <div className="grid grid-cols-2 md:flex gap-x-4">
<<<<<<< HEAD
                    <a href="https://portal.csun.edu/login" target="_blank" className="text-Montserrat underline hover:no-underline">Portal</a>
                    <a href="https://canvas.csun.edu/" target="_blank" className="text-Montserrat underline hover:no-underline">Canvas</a>
                    <a href="https://www.csun.edu/class-search" target="_blank" className="text-Montserrat underline hover:no-underline whitespace-nowrap">Class Finder</a>
=======
                    <a href="https://portal.csun.edu/login" target="_blank" className="text-Montserrat underline hover:no-underline text-white">Portal</a>
                    <a href="https://canvas.csun.edu/" target="_blank" className="text-Montserrat underline hover:no-underline text-white">Canvas</a>
                    <a href="https://www.csun.edu/class-search" target="_blank" className="text-Montserrat underline hover:no-underline whitespace-nowrap text-white">Class Finder</a>
>>>>>>> prod
                </div>
            </div>
        </footer>
    );
}