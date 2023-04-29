/*    */ package mzm.gsp.homeland;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class HomeRankData implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long roleid;
/*    */   public Octets name;
/*    */   public Octets partnername;
/*    */   public int point;
/*    */   
/*    */   public HomeRankData()
/*    */   {
/* 18 */     this.name = new Octets();
/* 19 */     this.partnername = new Octets();
/*    */   }
/*    */   
/*    */   public HomeRankData(int _rank_, long _roleid_, Octets _name_, Octets _partnername_, int _point_) {
/* 23 */     this.rank = _rank_;
/* 24 */     this.roleid = _roleid_;
/* 25 */     this.name = _name_;
/* 26 */     this.partnername = _partnername_;
/* 27 */     this.point = _point_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 35 */     _os_.marshal(this.rank);
/* 36 */     _os_.marshal(this.roleid);
/* 37 */     _os_.marshal(this.name);
/* 38 */     _os_.marshal(this.partnername);
/* 39 */     _os_.marshal(this.point);
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 44 */     this.rank = _os_.unmarshal_int();
/* 45 */     this.roleid = _os_.unmarshal_long();
/* 46 */     this.name = _os_.unmarshal_Octets();
/* 47 */     this.partnername = _os_.unmarshal_Octets();
/* 48 */     this.point = _os_.unmarshal_int();
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 53 */     if (_o1_ == this) return true;
/* 54 */     if ((_o1_ instanceof HomeRankData)) {
/* 55 */       HomeRankData _o_ = (HomeRankData)_o1_;
/* 56 */       if (this.rank != _o_.rank) return false;
/* 57 */       if (this.roleid != _o_.roleid) return false;
/* 58 */       if (!this.name.equals(_o_.name)) return false;
/* 59 */       if (!this.partnername.equals(_o_.partnername)) return false;
/* 60 */       if (this.point != _o_.point) return false;
/* 61 */       return true;
/*    */     }
/* 63 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 67 */     int _h_ = 0;
/* 68 */     _h_ += this.rank;
/* 69 */     _h_ += (int)this.roleid;
/* 70 */     _h_ += this.name.hashCode();
/* 71 */     _h_ += this.partnername.hashCode();
/* 72 */     _h_ += this.point;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append(this.rank).append(",");
/* 80 */     _sb_.append(this.roleid).append(",");
/* 81 */     _sb_.append("B").append(this.name.size()).append(",");
/* 82 */     _sb_.append("B").append(this.partnername.size()).append(",");
/* 83 */     _sb_.append(this.point).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\HomeRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */