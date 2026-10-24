class StudentCard(
    val nim: String,
    var nama: String,
    val prodi: String
) {
    var totalSks: Int = 0
        private set

    val status: String
        get() = if (totalSks > 0) "Aktif" else "Baru"

    init {
        require(nim.length >= 7) { "NIM tidak valid" }
    }

    fun ambilSks(jumlah: Int) {
        if (jumlah > 0 && totalSks + jumlah <= 24) {
            totalSks += jumlah
        }
    }

    fun ringkasan() =
        "$nim · $nama · $prodi · $totalSks SKS"
}

fun main() {
    val mahasiswa = StudentCard(
        nim = "21090090",
        nama = "Abdillah Gumara",
        prodi = "Informatika"
    )

    mahasiswa.ambilSks(24)

    println(mahasiswa.ringkasan())
    println("Status: ${mahasiswa.status}")
}
