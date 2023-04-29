/*    */ package mzm.gsp.map;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSyncMonsterNameChange
/*    */   extends __SSyncMonsterNameChange__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12590901;
/*    */   public int monsterinstanceid;
/*    */   public String newname;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12590901;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncMonsterNameChange()
/*    */   {
/* 34 */     this.newname = "";
/*    */   }
/*    */   
/*    */   public SSyncMonsterNameChange(int _monsterinstanceid_, String _newname_) {
/* 38 */     this.monsterinstanceid = _monsterinstanceid_;
/* 39 */     this.newname = _newname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.monsterinstanceid);
/* 48 */     _os_.marshal(this.newname, "UTF-16LE");
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.monsterinstanceid = _os_.unmarshal_int();
/* 54 */     this.newname = _os_.unmarshal_String("UTF-16LE");
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SSyncMonsterNameChange)) {
/* 64 */       SSyncMonsterNameChange _o_ = (SSyncMonsterNameChange)_o1_;
/* 65 */       if (this.monsterinstanceid != _o_.monsterinstanceid) return false;
/* 66 */       if (!this.newname.equals(_o_.newname)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.monsterinstanceid;
/* 75 */     _h_ += this.newname.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.monsterinstanceid).append(",");
/* 83 */     _sb_.append("T").append(this.newname.length()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\SSyncMonsterNameChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */