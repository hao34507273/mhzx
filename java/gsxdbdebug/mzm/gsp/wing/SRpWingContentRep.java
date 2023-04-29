/*    */ package mzm.gsp.wing;
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
/*    */ public class SRpWingContentRep
/*    */   extends __SRpWingContentRep__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596539;
/*    */   public int cfgid;
/*    */   public byte resettype;
/*    */   public ArrayList<Integer> curids;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596539;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SRpWingContentRep()
/*    */   {
/* 35 */     this.curids = new ArrayList();
/*    */   }
/*    */   
/*    */   public SRpWingContentRep(int _cfgid_, byte _resettype_, ArrayList<Integer> _curids_) {
/* 39 */     this.cfgid = _cfgid_;
/* 40 */     this.resettype = _resettype_;
/* 41 */     this.curids = _curids_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.cfgid);
/* 50 */     _os_.marshal(this.resettype);
/* 51 */     _os_.compact_uint32(this.curids.size());
/* 52 */     for (Integer _v_ : this.curids) {
/* 53 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 55 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 59 */     this.cfgid = _os_.unmarshal_int();
/* 60 */     this.resettype = _os_.unmarshal_byte();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.curids.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof SRpWingContentRep)) {
/* 75 */       SRpWingContentRep _o_ = (SRpWingContentRep)_o1_;
/* 76 */       if (this.cfgid != _o_.cfgid) return false;
/* 77 */       if (this.resettype != _o_.resettype) return false;
/* 78 */       if (!this.curids.equals(_o_.curids)) return false;
/* 79 */       return true;
/*    */     }
/* 81 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 85 */     int _h_ = 0;
/* 86 */     _h_ += this.cfgid;
/* 87 */     _h_ += this.resettype;
/* 88 */     _h_ += this.curids.hashCode();
/* 89 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 93 */     StringBuilder _sb_ = new StringBuilder();
/* 94 */     _sb_.append("(");
/* 95 */     _sb_.append(this.cfgid).append(",");
/* 96 */     _sb_.append(this.resettype).append(",");
/* 97 */     _sb_.append(this.curids).append(",");
/* 98 */     _sb_.append(")");
/* 99 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SRpWingContentRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */