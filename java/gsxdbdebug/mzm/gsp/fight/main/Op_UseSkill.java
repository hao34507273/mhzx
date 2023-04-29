/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.fight.OpSkill;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class Op_UseSkill
/*    */   extends OpSkill
/*    */ {
/* 16 */   public int skillLv = 0;
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 19 */     super.marshal(_os_);
/* 20 */     _os_.marshal(this.skillLv);
/* 21 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 25 */     super.unmarshal(_os_);
/* 26 */     this.skillLv = _os_.unmarshal_int();
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 31 */     if ((super.equals(_o1_)) && 
/* 32 */       ((_o1_ instanceof Op_UseSkill))) {
/* 33 */       Op_UseSkill _o_ = (Op_UseSkill)_o1_;
/* 34 */       return this.skillLv == _o_.skillLv;
/*    */     }
/*    */     
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 42 */     int _h_ = super.hashCode() + this.skillLv;
/* 43 */     return _h_;
/*    */   }
/*    */   
/*    */   public int compareTo(Op_UseSkill _o_) {
/* 47 */     int c = super.compareTo(_o_);
/* 48 */     if (c != 0) {
/* 49 */       return c;
/*    */     }
/* 51 */     return this.skillLv - _o_.skillLv;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\Op_UseSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */