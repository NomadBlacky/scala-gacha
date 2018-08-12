provider "aws" {
  version = "~> 1.31"
  region = "ap-northeast-1"
}

resource "aws_ecr_repository" "scala_gacha" {
  name = "scala-gacha"
}

output "ecr" {
  value = "${aws_ecr_repository.scala_gacha.repository_url}"
}
