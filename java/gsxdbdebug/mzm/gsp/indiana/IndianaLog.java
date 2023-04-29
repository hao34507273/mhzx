/*    */ package mzm.gsp.indiana;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class IndianaLog implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public int turn;
/*    */   public int sortid;
/*    */   public int award_number;
/*    */   public long roleid;
/*    */   public Octets role_name;
/*    */   
/*    */   public IndianaLog()
/*    */   {
/* 16 */     this.role_name = new Octets();
/*    */   }
/*    */   
/*    */   public IndianaLog(int _turn_, int _sortid_, int _award_number_, long _roleid_, Octets _role_name_) {
/* 20 */     this.turn = _turn_;
/* 21 */     this.sortid = _sortid_;
/* 22 */     this.award_number = _award_number_;
/* 23 */     this.roleid = _roleid_;
/* 24 */     this.role_name = _role_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.turn);
/* 33 */     _os_.marshal(this.sortid);
/* 34 */     _os_.marshal(this.award_number);
/* 35 */     _os_.marshal(this.roleid);
/* 36 */     _os_.marshal(this.role_name);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 41 */     this.turn = _os_.unmarshal_int();
/* 42 */     this.sortid = _os_.unmarshal_int();
/* 43 */     this.award_number = _os_.unmarshal_int();
/* 44 */     this.roleid = _os_.unmarshal_long();
/* 45 */     this.role_name = _os_.unmarshal_Octets();
/* 46 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 50 */     if (_o1_ == this) return true;
/* 51 */     if ((_o1_ instanceof IndianaLog)) {
/* 52 */       IndianaLog _o_ = (IndianaLog)_o1_;
/* 53 */       if (this.turn != _o_.turn) return false;
/* 54 */       if (this.sortid != _o_.sortid) return false;
/* 55 */       if (this.award_number != _o_.award_number) return false;
/* 56 */       if (this.roleid != _o_.roleid) return false;
/* 57 */       if (!this.role_name.equals(_o_.role_name)) return false;
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 64 */     int _h_ = 0;
/* 65 */     _h_ += this.turn;
/* 66 */     _h_ += this.sortid;
/* 67 */     _h_ += this.award_number;
/* 68 */     _h_ += (int)this.roleid;
/* 69 */     _h_ += this.role_name.hashCode();
/* 70 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 74 */     StringBuilder _sb_ = new StringBuilder();
/* 75 */     _sb_.append("(");
/* 76 */     _sb_.append(this.turn).append(",");
/* 77 */     _sb_.append(this.sortid).append(",");
/* 78 */     _sb_.append(this.award_number).append(",");
/* 79 */     _sb_.append(this.roleid).append(",");
/* 80 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\IndianaLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */