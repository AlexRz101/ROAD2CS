export default function Footer() {
    return (
        <footer className="w-full bg-black text-white py-4">
            <div className="px-8 flex justify-between items-center">
                <div className="text-Montserrat">
                    © {new Date().getFullYear()} California State University Northridge
                </div>
                <div className="grid grid-cols-2 md:flex gap-x-4">
                    <a href="https://portal.csun.edu/login" target="_blank" className="text-Montserrat underline hover:no-underline">Portal</a>
                    <a href="https://canvas.csun.edu/" target="_blank" className="text-Montserrat underline hover:no-underline">Canvas</a>
                    <a href="https://www.csun.edu/class-search" target="_blank" className="text-Montserrat underline hover:no-underline whitespace-nowrap">Class Finder</a>
                </div>
            </div>
        </footer>
    );
}