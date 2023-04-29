/*    */ package mzm.gsp.teamplatform;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetTeamsInfo
/*    */   extends __CGetTeamsInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 797191;
/*    */   public ArrayList<Long> teamids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 28 */     return 797191;
/*    */   }
/*    */   
/*    */ 
/*    */   public CGetTeamsInfo()
/*    */   {
/* 34 */     this.teamids = new ArrayList();
/*    */   }
/*    */   
/*    */   public CGetTeamsInfo(ArrayList<Long> _teamids_) {
/* 38 */     this.teamids = _teamids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.compact_uint32(this.teamids.size());
/* 47 */     for (Long _v_ : this.teamids) {
/* 48 */       _os_.marshal(_v_.longValue());
/*    */     }
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 56 */       long _v_ = _os_.unmarshal_long();
/* 57 */       this.teamids.add(Long.valueOf(_v_));
/*    */     }
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CGetTeamsInfo)) {
/* 68 */       CGetTeamsInfo _o_ = (CGetTeamsInfo)_o1_;
/* 69 */       if (!this.teamids.equals(_o_.teamids)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.teamids.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.teamids).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\CGetTeamsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */