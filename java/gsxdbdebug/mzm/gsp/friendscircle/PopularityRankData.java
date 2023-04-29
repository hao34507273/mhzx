/*    */ package mzm.gsp.friendscircle;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class PopularityRankData implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long roleid;
/*    */   public Octets name;
/*    */   public int popularity_value;
/*    */   public int occupation_id;
/*    */   
/*    */   public PopularityRankData()
/*    */   {
/* 18 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public PopularityRankData(int _rank_, long _roleid_, Octets _name_, int _popularity_value_, int _occupation_id_) {
/* 22 */     this.rank = _rank_;
/* 23 */     this.roleid = _roleid_;
/* 24 */     this.name = _name_;
/* 25 */     this.popularity_value = _popularity_value_;
/* 26 */     this.occupation_id = _occupation_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 34 */     _os_.marshal(this.rank);
/* 35 */     _os_.marshal(this.roleid);
/* 36 */     _os_.marshal(this.name);
/* 37 */     _os_.marshal(this.popularity_value);
/* 38 */     _os_.marshal(this.occupation_id);
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 43 */     this.rank = _os_.unmarshal_int();
/* 44 */     this.roleid = _os_.unmarshal_long();
/* 45 */     this.name = _os_.unmarshal_Octets();
/* 46 */     this.popularity_value = _os_.unmarshal_int();
/* 47 */     this.occupation_id = _os_.unmarshal_int();
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 52 */     if (_o1_ == this) return true;
/* 53 */     if ((_o1_ instanceof PopularityRankData)) {
/* 54 */       PopularityRankData _o_ = (PopularityRankData)_o1_;
/* 55 */       if (this.rank != _o_.rank) return false;
/* 56 */       if (this.roleid != _o_.roleid) return false;
/* 57 */       if (!this.name.equals(_o_.name)) return false;
/* 58 */       if (this.popularity_value != _o_.popularity_value) return false;
/* 59 */       if (this.occupation_id != _o_.occupation_id) return false;
/* 60 */       return true;
/*    */     }
/* 62 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 66 */     int _h_ = 0;
/* 67 */     _h_ += this.rank;
/* 68 */     _h_ += (int)this.roleid;
/* 69 */     _h_ += this.name.hashCode();
/* 70 */     _h_ += this.popularity_value;
/* 71 */     _h_ += this.occupation_id;
/* 72 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 76 */     StringBuilder _sb_ = new StringBuilder();
/* 77 */     _sb_.append("(");
/* 78 */     _sb_.append(this.rank).append(",");
/* 79 */     _sb_.append(this.roleid).append(",");
/* 80 */     _sb_.append("B").append(this.name.size()).append(",");
/* 81 */     _sb_.append(this.popularity_value).append(",");
/* 82 */     _sb_.append(this.occupation_id).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friendscircle\PopularityRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */