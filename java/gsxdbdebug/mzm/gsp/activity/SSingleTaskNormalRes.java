/*    */ package mzm.gsp.activity;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSingleTaskNormalRes
/*    */   extends __SSingleTaskNormalRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12587605;
/*    */   public static final int SINGLE_ROLE_TEAM = 1;
/*    */   public static final int ACTIVITY_IN_FORCE_CLOSE = 2;
/*    */   public static final int ACTIVITY_IN_PAUSE = 3;
/*    */   public static final int ACTIVITY_COUNT_TO_MAX = 4;
/*    */   public static final int NOT_NEAR_NPC = 5;
/*    */   public static final int ALREADY_OWN_GRAPH = 6;
/*    */   public int result;
/*    */   public ArrayList<String> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12587605;
/*    */   }
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
/*    */   public SSingleTaskNormalRes()
/*    */   {
/* 41 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSingleTaskNormalRes(int _result_, ArrayList<String> _args_) {
/* 45 */     this.result = _result_;
/* 46 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.result);
/* 55 */     _os_.compact_uint32(this.args.size());
/* 56 */     for (String _v_ : this.args) {
/* 57 */       _os_.marshal(_v_, "UTF-16LE");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 63 */     this.result = _os_.unmarshal_int();
/* 64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 66 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 67 */       this.args.add(_v_);
/*    */     }
/* 69 */     if (!_validator_()) {
/* 70 */       throw new VerifyError("validator failed");
/*    */     }
/* 72 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 76 */     if (_o1_ == this) return true;
/* 77 */     if ((_o1_ instanceof SSingleTaskNormalRes)) {
/* 78 */       SSingleTaskNormalRes _o_ = (SSingleTaskNormalRes)_o1_;
/* 79 */       if (this.result != _o_.result) return false;
/* 80 */       if (!this.args.equals(_o_.args)) return false;
/* 81 */       return true;
/*    */     }
/* 83 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 87 */     int _h_ = 0;
/* 88 */     _h_ += this.result;
/* 89 */     _h_ += this.args.hashCode();
/* 90 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 94 */     StringBuilder _sb_ = new StringBuilder();
/* 95 */     _sb_.append("(");
/* 96 */     _sb_.append(this.result).append(",");
/* 97 */     _sb_.append(this.args).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SSingleTaskNormalRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */