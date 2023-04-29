/*    */ package mzm.gsp.fight;
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
/*    */ public class SCommandChangeRes
/*    */   extends __SCommandChangeRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594196;
/*    */   public int commandtype;
/*    */   public int commandindex;
/*    */   public String commandname;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594196;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SCommandChangeRes()
/*    */   {
/* 35 */     this.commandname = "";
/*    */   }
/*    */   
/*    */   public SCommandChangeRes(int _commandtype_, int _commandindex_, String _commandname_) {
/* 39 */     this.commandtype = _commandtype_;
/* 40 */     this.commandindex = _commandindex_;
/* 41 */     this.commandname = _commandname_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.commandtype);
/* 50 */     _os_.marshal(this.commandindex);
/* 51 */     _os_.marshal(this.commandname, "UTF-16LE");
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.commandtype = _os_.unmarshal_int();
/* 57 */     this.commandindex = _os_.unmarshal_int();
/* 58 */     this.commandname = _os_.unmarshal_String("UTF-16LE");
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof SCommandChangeRes)) {
/* 68 */       SCommandChangeRes _o_ = (SCommandChangeRes)_o1_;
/* 69 */       if (this.commandtype != _o_.commandtype) return false;
/* 70 */       if (this.commandindex != _o_.commandindex) return false;
/* 71 */       if (!this.commandname.equals(_o_.commandname)) return false;
/* 72 */       return true;
/*    */     }
/* 74 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 78 */     int _h_ = 0;
/* 79 */     _h_ += this.commandtype;
/* 80 */     _h_ += this.commandindex;
/* 81 */     _h_ += this.commandname.hashCode();
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(this.commandtype).append(",");
/* 89 */     _sb_.append(this.commandindex).append(",");
/* 90 */     _sb_.append("T").append(this.commandname.length()).append(",");
/* 91 */     _sb_.append(")");
/* 92 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SCommandChangeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */