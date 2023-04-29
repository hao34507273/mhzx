/*    */ package mzm.gsp.bounty;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SSynBountyInfo
/*    */   extends __SSynBountyInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584193;
/*    */   public int bountycount;
/*    */   public HashMap<Integer, BTaskInfo> taskinfos;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584193;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynBountyInfo()
/*    */   {
/* 34 */     this.taskinfos = new HashMap();
/*    */   }
/*    */   
/*    */   public SSynBountyInfo(int _bountycount_, HashMap<Integer, BTaskInfo> _taskinfos_) {
/* 38 */     this.bountycount = _bountycount_;
/* 39 */     this.taskinfos = _taskinfos_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     for (Map.Entry<Integer, BTaskInfo> _e_ : this.taskinfos.entrySet()) {
/* 44 */       if (!((BTaskInfo)_e_.getValue())._validator_()) return false;
/*    */     }
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.bountycount);
/* 51 */     _os_.compact_uint32(this.taskinfos.size());
/* 52 */     for (Map.Entry<Integer, BTaskInfo> _e_ : this.taskinfos.entrySet()) {
/* 53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 54 */       _os_.marshal((Marshal)_e_.getValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.bountycount = _os_.unmarshal_int();
/* 61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*    */     {
/* 63 */       int _k_ = _os_.unmarshal_int();
/* 64 */       BTaskInfo _v_ = new BTaskInfo();
/* 65 */       _v_.unmarshal(_os_);
/* 66 */       this.taskinfos.put(Integer.valueOf(_k_), _v_);
/*    */     }
/* 68 */     if (!_validator_()) {
/* 69 */       throw new VerifyError("validator failed");
/*    */     }
/* 71 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 75 */     if (_o1_ == this) return true;
/* 76 */     if ((_o1_ instanceof SSynBountyInfo)) {
/* 77 */       SSynBountyInfo _o_ = (SSynBountyInfo)_o1_;
/* 78 */       if (this.bountycount != _o_.bountycount) return false;
/* 79 */       if (!this.taskinfos.equals(_o_.taskinfos)) return false;
/* 80 */       return true;
/*    */     }
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 86 */     int _h_ = 0;
/* 87 */     _h_ += this.bountycount;
/* 88 */     _h_ += this.taskinfos.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.bountycount).append(",");
/* 96 */     _sb_.append(this.taskinfos).append(",");
/* 97 */     _sb_.append(")");
/* 98 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bounty\SSynBountyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */