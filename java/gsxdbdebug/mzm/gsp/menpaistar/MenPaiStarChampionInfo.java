/*    */ package mzm.gsp.menpaistar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class MenPaiStarChampionInfo implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public Octets role_name;
/*    */   public int occupationid;
/*    */   public int point;
/*    */   
/*    */   public MenPaiStarChampionInfo()
/*    */   {
/* 17 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public MenPaiStarChampionInfo(long _roleid_, Octets _role_name_, int _occupationid_, int _point_) {
/* 21 */     this.roleid = _roleid_;
/* 22 */     this.role_name = _role_name_;
/* 23 */     this.occupationid = _occupationid_;
/* 24 */     this.point = _point_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.roleid);
/* 33 */     _os_.marshal(this.role_name);
/* 34 */     _os_.marshal(this.occupationid);
/* 35 */     _os_.marshal(this.point);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.roleid = _os_.unmarshal_long();
/* 41 */     this.role_name = _os_.unmarshal_Octets();
/* 42 */     this.occupationid = _os_.unmarshal_int();
/* 43 */     this.point = _os_.unmarshal_int();
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof MenPaiStarChampionInfo)) {
/* 50 */       MenPaiStarChampionInfo _o_ = (MenPaiStarChampionInfo)_o1_;
/* 51 */       if (this.roleid != _o_.roleid) return false;
/* 52 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 53 */       if (this.occupationid != _o_.occupationid) return false;
/* 54 */       if (this.point != _o_.point) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += (int)this.roleid;
/* 63 */     _h_ += this.role_name.hashCode();
/* 64 */     _h_ += this.occupationid;
/* 65 */     _h_ += this.point;
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append(this.roleid).append(",");
/* 73 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 74 */     _sb_.append(this.occupationid).append(",");
/* 75 */     _sb_.append(this.point).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\menpaistar\MenPaiStarChampionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */