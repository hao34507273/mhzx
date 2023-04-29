/*    */ package mzm.gsp.npc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynTeamerInteractNpcReq
/*    */   extends __SSynTeamerInteractNpcReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12586755;
/*    */   public int npcid;
/*    */   public ArrayList<Integer> args;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12586755;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynTeamerInteractNpcReq()
/*    */   {
/* 32 */     this.args = new ArrayList();
/*    */   }
/*    */   
/*    */   public SSynTeamerInteractNpcReq(int _npcid_, ArrayList<Integer> _args_) {
/* 36 */     this.npcid = _npcid_;
/* 37 */     this.args = _args_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.npcid);
/* 46 */     _os_.compact_uint32(this.args.size());
/* 47 */     for (Integer _v_ : this.args) {
/* 48 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.npcid = _os_.unmarshal_int();
/* 55 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 57 */       int _v_ = _os_.unmarshal_int();
/* 58 */       this.args.add(Integer.valueOf(_v_));
/*    */     }
/* 60 */     if (!_validator_()) {
/* 61 */       throw new VerifyError("validator failed");
/*    */     }
/* 63 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 67 */     if (_o1_ == this) return true;
/* 68 */     if ((_o1_ instanceof SSynTeamerInteractNpcReq)) {
/* 69 */       SSynTeamerInteractNpcReq _o_ = (SSynTeamerInteractNpcReq)_o1_;
/* 70 */       if (this.npcid != _o_.npcid) return false;
/* 71 */       if (!this.args.equals(_o_.args)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.npcid;
/* 80 */     _h_ += this.args.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append(this.npcid).append(",");
/* 88 */     _sb_.append(this.args).append(",");
/* 89 */     _sb_.append(")");
/* 90 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\SSynTeamerInteractNpcReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */