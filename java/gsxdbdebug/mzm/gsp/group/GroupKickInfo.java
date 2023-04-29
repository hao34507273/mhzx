/*    */ package mzm.gsp.group;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class GroupKickInfo implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets group_name;
/*    */   public Octets master_name;
/*    */   
/*    */   public GroupKickInfo()
/*    */   {
/* 13 */     this.group_name = new Octets();
/* 14 */     this.master_name = new Octets();
/*    */   }
/*    */   
/*    */   public GroupKickInfo(Octets _group_name_, Octets _master_name_) {
/* 18 */     this.group_name = _group_name_;
/* 19 */     this.master_name = _master_name_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.group_name);
/* 28 */     _os_.marshal(this.master_name);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 33 */     this.group_name = _os_.unmarshal_Octets();
/* 34 */     this.master_name = _os_.unmarshal_Octets();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof GroupKickInfo)) {
/* 41 */       GroupKickInfo _o_ = (GroupKickInfo)_o1_;
/* 42 */       if (!this.group_name.equals(_o_.group_name)) return false;
/* 43 */       if (!this.master_name.equals(_o_.master_name)) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.group_name.hashCode();
/* 52 */     _h_ += this.master_name.hashCode();
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append("B").append(this.group_name.size()).append(",");
/* 60 */     _sb_.append("B").append(this.master_name.size()).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\group\GroupKickInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */