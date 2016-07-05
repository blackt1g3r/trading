/**
 * Copyright (C) 2016 Yoann Manvieu
 *
 * This software is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.ymanvieu.trading.portofolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import fr.ymanvieu.trading.portofolio.entity.AssetEntity;

public interface AssetRepository extends JpaRepository<AssetEntity, Integer>, QueryDslPredicateExecutor<AssetEntity> {

	List<AssetEntity> findAllByUserLoginOrderBySymbolName(String login);

	AssetEntity findByUserLoginAndSymbolCode(String login, String code);

	List<AssetEntity> findAllByUserLoginAndSymbolCurrencyIsNull(String login);

	@Modifying
	void deleteAllBySymbolCode(String code);
}