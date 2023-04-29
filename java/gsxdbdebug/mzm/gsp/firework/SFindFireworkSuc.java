/*    */ package mzm.gsp.firework;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SFindFireworkSuc
/*    */   extends __SFindFireworkSuc__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12625154;
/*    */   public int activityid;
/*    */   public Octets name;
/*    */   public int num;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12625154;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SFindFireworkSuc()
/*    */   {
/* 35 */     this.name = new Octets();
/*    */   }
/*    */   
/*    */   public SFindFireworkSuc(int _activityid_, Octets _name_, int _num_) {
/* 39 */     this.activityid = _activityid_;
/* 40 */     this.name = _name_;
/* 41 */     this.num = _num_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.activityid);
/* 50 */     _os_.marshal(this.name);
/* 51 */     _os_.marshal(this.num);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.activityid = _os_.unmarshal_int();
/* 57 */     this.name = _os_.unmarshal_Octets();
/* 58 */     this.num = _os_.unmarshal_int();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SFindFireworkSuc)) {
/* 68 */       SFindFireworkSuc _o_ = (SFindFireworkSuc)_o1_;
/* 69 */       if (this.activityid != _o_.activityid) return false;
/* 70 */       if (!this.name.equals(_o_.name)) return false;
/* 71 */       if (this.num != _o_.num) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.activityid;
/* 80 */     _h_ += this.name.hashCode();
/* 81 */     _h_ += this.num;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.activityid).append(",");
/* 89 */     _sb_.append("B").append(this.name.size()).append(",");
/* 90 */     _sb_.append(this.num).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\SFindFireworkSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */