/*    */ package mzm.gsp.xiaohuikuaipao;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class InnerInfo implements Marshal
/*    */ {
/*    */   public int ticketcount;
/*    */   public ArrayList<Integer> hitindexes;
/*    */   
/*    */   public InnerInfo()
/*    */   {
/* 15 */     this.hitindexes = new ArrayList();
/*    */   }
/*    */   
/*    */   public InnerInfo(int _ticketcount_, ArrayList<Integer> _hitindexes_) {
/* 19 */     this.ticketcount = _ticketcount_;
/* 20 */     this.hitindexes = _hitindexes_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.ticketcount);
/* 29 */     _os_.compact_uint32(this.hitindexes.size());
/* 30 */     for (Integer _v_ : this.hitindexes) {
/* 31 */       _os_.marshal(_v_.intValue());
/*    */     }
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.ticketcount = _os_.unmarshal_int();
/* 38 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 40 */       int _v_ = _os_.unmarshal_int();
/* 41 */       this.hitindexes.add(Integer.valueOf(_v_));
/*    */     }
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 47 */     if (_o1_ == this) return true;
/* 48 */     if ((_o1_ instanceof InnerInfo)) {
/* 49 */       InnerInfo _o_ = (InnerInfo)_o1_;
/* 50 */       if (this.ticketcount != _o_.ticketcount) return false;
/* 51 */       if (!this.hitindexes.equals(_o_.hitindexes)) return false;
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 58 */     int _h_ = 0;
/* 59 */     _h_ += this.ticketcount;
/* 60 */     _h_ += this.hitindexes.hashCode();
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.ticketcount).append(",");
/* 68 */     _sb_.append(this.hitindexes).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\xiaohuikuaipao\InnerInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */