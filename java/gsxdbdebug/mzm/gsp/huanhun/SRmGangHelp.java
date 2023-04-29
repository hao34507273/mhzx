/*    */ package mzm.gsp.huanhun;
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
/*    */ public class SRmGangHelp
/*    */   extends __SRmGangHelp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584465;
/*    */   public long roleid;
/*    */   public ArrayList<Integer> boxindexs;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12584465;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SRmGangHelp()
/*    */   {
/* 34 */     this.boxindexs = new ArrayList();
/*    */   }
/*    */   
/*    */   public SRmGangHelp(long _roleid_, ArrayList<Integer> _boxindexs_) {
/* 38 */     this.roleid = _roleid_;
/* 39 */     this.boxindexs = _boxindexs_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.roleid);
/* 48 */     _os_.compact_uint32(this.boxindexs.size());
/* 49 */     for (Integer _v_ : this.boxindexs) {
/* 50 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.roleid = _os_.unmarshal_long();
/* 57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 59 */       int _v_ = _os_.unmarshal_int();
/* 60 */       this.boxindexs.add(Integer.valueOf(_v_));
/*    */     }
/* 62 */     if (!_validator_()) {
/* 63 */       throw new VerifyError("validator failed");
/*    */     }
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 69 */     if (_o1_ == this) return true;
/* 70 */     if ((_o1_ instanceof SRmGangHelp)) {
/* 71 */       SRmGangHelp _o_ = (SRmGangHelp)_o1_;
/* 72 */       if (this.roleid != _o_.roleid) return false;
/* 73 */       if (!this.boxindexs.equals(_o_.boxindexs)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += (int)this.roleid;
/* 82 */     _h_ += this.boxindexs.hashCode();
/* 83 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 87 */     StringBuilder _sb_ = new StringBuilder();
/* 88 */     _sb_.append("(");
/* 89 */     _sb_.append(this.roleid).append(",");
/* 90 */     _sb_.append(this.boxindexs).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\SRmGangHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */