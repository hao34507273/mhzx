/*    */ package mzm.gsp.bigboss;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class BigbossRankData
/*    */   implements Marshal
/*    */ {
/*    */   public int rank;
/*    */   public long roleid;
/*    */   public String name;
/*    */   public int occupationid;
/*    */   public int damagepoint;
/*    */   public int step;
/*    */   
/*    */   public BigbossRankData()
/*    */   {
/* 19 */     this.name = "";
/*    */   }
/*    */   
/*    */   public BigbossRankData(int _rank_, long _roleid_, String _name_, int _occupationid_, int _damagepoint_, int _step_) {
/* 23 */     this.rank = _rank_;
/* 24 */     this.roleid = _roleid_;
/* 25 */     this.name = _name_;
/* 26 */     this.occupationid = _occupationid_;
/* 27 */     this.damagepoint = _damagepoint_;
/* 28 */     this.step = _step_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.rank);
/* 37 */     _os_.marshal(this.roleid);
/* 38 */     _os_.marshal(this.name, "UTF-16LE");
/* 39 */     _os_.marshal(this.occupationid);
/* 40 */     _os_.marshal(this.damagepoint);
/* 41 */     _os_.marshal(this.step);
/* 42 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 46 */     this.rank = _os_.unmarshal_int();
/* 47 */     this.roleid = _os_.unmarshal_long();
/* 48 */     this.name = _os_.unmarshal_String("UTF-16LE");
/* 49 */     this.occupationid = _os_.unmarshal_int();
/* 50 */     this.damagepoint = _os_.unmarshal_int();
/* 51 */     this.step = _os_.unmarshal_int();
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 56 */     if (_o1_ == this) return true;
/* 57 */     if ((_o1_ instanceof BigbossRankData)) {
/* 58 */       BigbossRankData _o_ = (BigbossRankData)_o1_;
/* 59 */       if (this.rank != _o_.rank) return false;
/* 60 */       if (this.roleid != _o_.roleid) return false;
/* 61 */       if (!this.name.equals(_o_.name)) return false;
/* 62 */       if (this.occupationid != _o_.occupationid) return false;
/* 63 */       if (this.damagepoint != _o_.damagepoint) return false;
/* 64 */       if (this.step != _o_.step) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.rank;
/* 73 */     _h_ += (int)this.roleid;
/* 74 */     _h_ += this.name.hashCode();
/* 75 */     _h_ += this.occupationid;
/* 76 */     _h_ += this.damagepoint;
/* 77 */     _h_ += this.step;
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.rank).append(",");
/* 85 */     _sb_.append(this.roleid).append(",");
/* 86 */     _sb_.append("T").append(this.name.length()).append(",");
/* 87 */     _sb_.append(this.occupationid).append(",");
/* 88 */     _sb_.append(this.damagepoint).append(",");
/* 89 */     _sb_.append(this.step).append(",");
/* 90 */     _sb_.append(")");
/* 91 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\BigbossRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */