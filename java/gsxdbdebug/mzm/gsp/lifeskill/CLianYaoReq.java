/*    */ package mzm.gsp.lifeskill;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.lifeskill.main.PLianYaoReq;
/*    */ 
/*    */ 
/*    */ public class CLianYaoReq
/*    */   extends __CLianYaoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12589058;
/*    */   public int skillbagid;
/*    */   public LinkedList<Integer> itemkeylist;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PLianYaoReq(roleId, this.skillbagid, this.itemkeylist));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12589058;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CLianYaoReq()
/*    */   {
/* 38 */     this.itemkeylist = new LinkedList();
/*    */   }
/*    */   
/*    */   public CLianYaoReq(int _skillbagid_, LinkedList<Integer> _itemkeylist_) {
/* 42 */     this.skillbagid = _skillbagid_;
/* 43 */     this.itemkeylist = _itemkeylist_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.skillbagid);
/* 52 */     _os_.compact_uint32(this.itemkeylist.size());
/* 53 */     for (Integer _v_ : this.itemkeylist) {
/* 54 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 60 */     this.skillbagid = _os_.unmarshal_int();
/* 61 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 63 */       int _v_ = _os_.unmarshal_int();
/* 64 */       this.itemkeylist.add(Integer.valueOf(_v_));
/*    */     }
/* 66 */     if (!_validator_()) {
/* 67 */       throw new VerifyError("validator failed");
/*    */     }
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof CLianYaoReq)) {
/* 75 */       CLianYaoReq _o_ = (CLianYaoReq)_o1_;
/* 76 */       if (this.skillbagid != _o_.skillbagid) return false;
/* 77 */       if (!this.itemkeylist.equals(_o_.itemkeylist)) return false;
/* 78 */       return true;
/*    */     }
/* 80 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 84 */     int _h_ = 0;
/* 85 */     _h_ += this.skillbagid;
/* 86 */     _h_ += this.itemkeylist.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.skillbagid).append(",");
/* 94 */     _sb_.append(this.itemkeylist).append(",");
/* 95 */     _sb_.append(")");
/* 96 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\CLianYaoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */