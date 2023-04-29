/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class NoneRealTimeSnsRoles extends XBean implements xbean.NoneRealTimeSnsRoles
/*     */ {
/*     */   private long savetime;
/*     */   private ArrayList<Long> roleids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.savetime = 0L;
/*  21 */     this.roleids.clear();
/*     */   }
/*     */   
/*     */   NoneRealTimeSnsRoles(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*  27 */     this.roleids = new ArrayList();
/*     */   }
/*     */   
/*     */   public NoneRealTimeSnsRoles()
/*     */   {
/*  32 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public NoneRealTimeSnsRoles(NoneRealTimeSnsRoles _o_)
/*     */   {
/*  37 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   NoneRealTimeSnsRoles(xbean.NoneRealTimeSnsRoles _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  42 */     super(_xp_, _vn_);
/*  43 */     if ((_o1_ instanceof NoneRealTimeSnsRoles)) { assign((NoneRealTimeSnsRoles)_o1_);
/*  44 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  45 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  46 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(NoneRealTimeSnsRoles _o_) {
/*  51 */     _o_._xdb_verify_unsafe_();
/*  52 */     this.savetime = _o_.savetime;
/*  53 */     this.roleids = new ArrayList();
/*  54 */     this.roleids.addAll(_o_.roleids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  59 */     this.savetime = _o_.savetime;
/*  60 */     this.roleids = new ArrayList();
/*  61 */     this.roleids.addAll(_o_.roleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     _os_.marshal(this.savetime);
/*  69 */     _os_.compact_uint32(this.roleids.size());
/*  70 */     for (Long _v_ : this.roleids)
/*     */     {
/*  72 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.savetime = _os_.unmarshal_long();
/*  82 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  84 */       long _v_ = 0L;
/*  85 */       _v_ = _os_.unmarshal_long();
/*  86 */       this.roleids.add(Long.valueOf(_v_));
/*     */     }
/*  88 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  94 */     _xdb_verify_unsafe_();
/*  95 */     int _size_ = 0;
/*  96 */     _size_ += CodedOutputStream.computeInt64Size(1, this.savetime);
/*  97 */     for (Long _v_ : this.roleids)
/*     */     {
/*  99 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 101 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 107 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 110 */       _output_.writeInt64(1, this.savetime);
/* 111 */       for (Long _v_ : this.roleids)
/*     */       {
/* 113 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.savetime = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           long _v_ = 0L;
/* 148 */           _v_ = _input_.readInt64();
/* 149 */           this.roleids.add(Long.valueOf(_v_));
/* 150 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 154 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 156 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 165 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 169 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 171 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NoneRealTimeSnsRoles copy()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new NoneRealTimeSnsRoles(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NoneRealTimeSnsRoles toData()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.NoneRealTimeSnsRoles toBean()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new NoneRealTimeSnsRoles(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.NoneRealTimeSnsRoles toDataIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.NoneRealTimeSnsRoles toBeanIf()
/*     */   {
/* 203 */     _xdb_verify_unsafe_();
/* 204 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 210 */     _xdb_verify_unsafe_();
/* 211 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSavetime()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return this.savetime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getRoleids()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return xdb.Logs.logList(new LogKey(this, "roleids"), this.roleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getRoleidsAsData()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/*     */     
/* 235 */     NoneRealTimeSnsRoles _o_ = this;
/* 236 */     List<Long> roleids = new ArrayList();
/* 237 */     roleids.addAll(_o_.roleids);
/* 238 */     return roleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSavetime(long _v_)
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     xdb.Logs.logIf(new LogKey(this, "savetime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 250 */         new xdb.logs.LogLong(this, NoneRealTimeSnsRoles.this.savetime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 254 */             NoneRealTimeSnsRoles.this.savetime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 258 */     });
/* 259 */     this.savetime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 265 */     _xdb_verify_unsafe_();
/* 266 */     NoneRealTimeSnsRoles _o_ = null;
/* 267 */     if ((_o1_ instanceof NoneRealTimeSnsRoles)) { _o_ = (NoneRealTimeSnsRoles)_o1_;
/* 268 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 269 */       return false;
/* 270 */     if (this.savetime != _o_.savetime) return false;
/* 271 */     if (!this.roleids.equals(_o_.roleids)) return false;
/* 272 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     int _h_ = 0;
/* 280 */     _h_ = (int)(_h_ + this.savetime);
/* 281 */     _h_ += this.roleids.hashCode();
/* 282 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     StringBuilder _sb_ = new StringBuilder();
/* 290 */     _sb_.append("(");
/* 291 */     _sb_.append(this.savetime);
/* 292 */     _sb_.append(",");
/* 293 */     _sb_.append(this.roleids);
/* 294 */     _sb_.append(")");
/* 295 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 301 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 302 */     lb.add(new xdb.logs.ListenableChanged().setVarName("savetime"));
/* 303 */     lb.add(new xdb.logs.ListenableChanged().setVarName("roleids"));
/* 304 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.NoneRealTimeSnsRoles {
/*     */     private Const() {}
/*     */     
/*     */     NoneRealTimeSnsRoles nThis() {
/* 311 */       return NoneRealTimeSnsRoles.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 317 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimeSnsRoles copy()
/*     */     {
/* 323 */       return NoneRealTimeSnsRoles.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimeSnsRoles toData()
/*     */     {
/* 329 */       return NoneRealTimeSnsRoles.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.NoneRealTimeSnsRoles toBean()
/*     */     {
/* 334 */       return NoneRealTimeSnsRoles.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimeSnsRoles toDataIf()
/*     */     {
/* 340 */       return NoneRealTimeSnsRoles.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.NoneRealTimeSnsRoles toBeanIf()
/*     */     {
/* 345 */       return NoneRealTimeSnsRoles.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSavetime()
/*     */     {
/* 352 */       NoneRealTimeSnsRoles.this._xdb_verify_unsafe_();
/* 353 */       return NoneRealTimeSnsRoles.this.savetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoleids()
/*     */     {
/* 360 */       NoneRealTimeSnsRoles.this._xdb_verify_unsafe_();
/* 361 */       return xdb.Consts.constList(NoneRealTimeSnsRoles.this.roleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getRoleidsAsData()
/*     */     {
/* 367 */       NoneRealTimeSnsRoles.this._xdb_verify_unsafe_();
/*     */       
/* 369 */       NoneRealTimeSnsRoles _o_ = NoneRealTimeSnsRoles.this;
/* 370 */       List<Long> roleids = new ArrayList();
/* 371 */       roleids.addAll(_o_.roleids);
/* 372 */       return roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSavetime(long _v_)
/*     */     {
/* 379 */       NoneRealTimeSnsRoles.this._xdb_verify_unsafe_();
/* 380 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 386 */       NoneRealTimeSnsRoles.this._xdb_verify_unsafe_();
/* 387 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 393 */       NoneRealTimeSnsRoles.this._xdb_verify_unsafe_();
/* 394 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 400 */       return NoneRealTimeSnsRoles.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 406 */       return NoneRealTimeSnsRoles.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 412 */       NoneRealTimeSnsRoles.this._xdb_verify_unsafe_();
/* 413 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 419 */       return NoneRealTimeSnsRoles.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 425 */       return NoneRealTimeSnsRoles.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 431 */       NoneRealTimeSnsRoles.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 438 */       return NoneRealTimeSnsRoles.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 444 */       return NoneRealTimeSnsRoles.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 450 */       return NoneRealTimeSnsRoles.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 456 */       return NoneRealTimeSnsRoles.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 462 */       return NoneRealTimeSnsRoles.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 468 */       return NoneRealTimeSnsRoles.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 474 */       return NoneRealTimeSnsRoles.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.NoneRealTimeSnsRoles
/*     */   {
/*     */     private long savetime;
/*     */     
/*     */     private ArrayList<Long> roleids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 493 */       this.roleids = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.NoneRealTimeSnsRoles _o1_)
/*     */     {
/* 498 */       if ((_o1_ instanceof NoneRealTimeSnsRoles)) { assign((NoneRealTimeSnsRoles)_o1_);
/* 499 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 500 */       } else if ((_o1_ instanceof NoneRealTimeSnsRoles.Const)) assign(((NoneRealTimeSnsRoles.Const)_o1_).nThis()); else {
/* 501 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(NoneRealTimeSnsRoles _o_) {
/* 506 */       this.savetime = _o_.savetime;
/* 507 */       this.roleids = new ArrayList();
/* 508 */       this.roleids.addAll(_o_.roleids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 513 */       this.savetime = _o_.savetime;
/* 514 */       this.roleids = new ArrayList();
/* 515 */       this.roleids.addAll(_o_.roleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       _os_.marshal(this.savetime);
/* 522 */       _os_.compact_uint32(this.roleids.size());
/* 523 */       for (Long _v_ : this.roleids)
/*     */       {
/* 525 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 527 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 533 */       this.savetime = _os_.unmarshal_long();
/* 534 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 536 */         long _v_ = 0L;
/* 537 */         _v_ = _os_.unmarshal_long();
/* 538 */         this.roleids.add(Long.valueOf(_v_));
/*     */       }
/* 540 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 546 */       int _size_ = 0;
/* 547 */       _size_ += CodedOutputStream.computeInt64Size(1, this.savetime);
/* 548 */       for (Long _v_ : this.roleids)
/*     */       {
/* 550 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 552 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 560 */         _output_.writeInt64(1, this.savetime);
/* 561 */         for (Long _v_ : this.roleids)
/*     */         {
/* 563 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 568 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 570 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 578 */         boolean done = false;
/* 579 */         while (!done)
/*     */         {
/* 581 */           int tag = _input_.readTag();
/* 582 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 586 */             done = true;
/* 587 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 591 */             this.savetime = _input_.readInt64();
/* 592 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 596 */             long _v_ = 0L;
/* 597 */             _v_ = _input_.readInt64();
/* 598 */             this.roleids.add(Long.valueOf(_v_));
/* 599 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 603 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 605 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 614 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 618 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 620 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimeSnsRoles copy()
/*     */     {
/* 626 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimeSnsRoles toData()
/*     */     {
/* 632 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.NoneRealTimeSnsRoles toBean()
/*     */     {
/* 637 */       return new NoneRealTimeSnsRoles(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.NoneRealTimeSnsRoles toDataIf()
/*     */     {
/* 643 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.NoneRealTimeSnsRoles toBeanIf()
/*     */     {
/* 648 */       return new NoneRealTimeSnsRoles(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 654 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 658 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 662 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 666 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 670 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 674 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 678 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSavetime()
/*     */     {
/* 685 */       return this.savetime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoleids()
/*     */     {
/* 692 */       return this.roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getRoleidsAsData()
/*     */     {
/* 699 */       return this.roleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSavetime(long _v_)
/*     */     {
/* 706 */       this.savetime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 712 */       if (!(_o1_ instanceof Data)) return false;
/* 713 */       Data _o_ = (Data)_o1_;
/* 714 */       if (this.savetime != _o_.savetime) return false;
/* 715 */       if (!this.roleids.equals(_o_.roleids)) return false;
/* 716 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 722 */       int _h_ = 0;
/* 723 */       _h_ = (int)(_h_ + this.savetime);
/* 724 */       _h_ += this.roleids.hashCode();
/* 725 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 731 */       StringBuilder _sb_ = new StringBuilder();
/* 732 */       _sb_.append("(");
/* 733 */       _sb_.append(this.savetime);
/* 734 */       _sb_.append(",");
/* 735 */       _sb_.append(this.roleids);
/* 736 */       _sb_.append(")");
/* 737 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\NoneRealTimeSnsRoles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */