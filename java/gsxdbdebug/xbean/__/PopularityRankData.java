/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class PopularityRankData extends XBean implements xbean.PopularityRankData
/*     */ {
/*     */   private LinkedList<xbean.RolePopularityRankData> rank_data_list;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.rank_data_list.clear();
/*     */   }
/*     */   
/*     */   PopularityRankData(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.rank_data_list = new LinkedList();
/*     */   }
/*     */   
/*     */   public PopularityRankData()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PopularityRankData(PopularityRankData _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PopularityRankData(xbean.PopularityRankData _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof PopularityRankData)) { assign((PopularityRankData)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PopularityRankData _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.rank_data_list = new LinkedList();
/*  50 */     for (xbean.RolePopularityRankData _v_ : _o_.rank_data_list) {
/*  51 */       this.rank_data_list.add(new RolePopularityRankData(_v_, this, "rank_data_list"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  56 */     this.rank_data_list = new LinkedList();
/*  57 */     for (xbean.RolePopularityRankData _v_ : _o_.rank_data_list) {
/*  58 */       this.rank_data_list.add(new RolePopularityRankData(_v_, this, "rank_data_list"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.compact_uint32(this.rank_data_list.size());
/*  66 */     for (xbean.RolePopularityRankData _v_ : this.rank_data_list)
/*     */     {
/*  68 */       _v_.marshal(_os_);
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  79 */       xbean.RolePopularityRankData _v_ = new RolePopularityRankData(0, this, "rank_data_list");
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.rank_data_list.add(_v_);
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     for (xbean.RolePopularityRankData _v_ : this.rank_data_list)
/*     */     {
/*  93 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */     }
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       for (xbean.RolePopularityRankData _v_ : this.rank_data_list)
/*     */       {
/* 106 */         _output_.writeMessage(1, _v_);
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 111 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 113 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 119 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 122 */       boolean done = false;
/* 123 */       while (!done)
/*     */       {
/* 125 */         int tag = _input_.readTag();
/* 126 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 130 */           done = true;
/* 131 */           break;
/*     */         
/*     */ 
/*     */         case 10: 
/* 135 */           xbean.RolePopularityRankData _v_ = new RolePopularityRankData(0, this, "rank_data_list");
/* 136 */           _input_.readMessage(_v_);
/* 137 */           this.rank_data_list.add(_v_);
/* 138 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 142 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 144 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 153 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 157 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 159 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PopularityRankData copy()
/*     */   {
/* 165 */     _xdb_verify_unsafe_();
/* 166 */     return new PopularityRankData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PopularityRankData toData()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PopularityRankData toBean()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new PopularityRankData(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PopularityRankData toDataIf()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PopularityRankData toBeanIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<xbean.RolePopularityRankData> getRank_data_list()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return xdb.Logs.logList(new xdb.LogKey(this, "rank_data_list"), this.rank_data_list);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<xbean.RolePopularityRankData> getRank_data_listAsData()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/*     */     
/* 215 */     PopularityRankData _o_ = this;
/* 216 */     List<xbean.RolePopularityRankData> rank_data_list = new LinkedList();
/* 217 */     for (xbean.RolePopularityRankData _v_ : _o_.rank_data_list)
/* 218 */       rank_data_list.add(new RolePopularityRankData.Data(_v_));
/* 219 */     return rank_data_list;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     PopularityRankData _o_ = null;
/* 227 */     if ((_o1_ instanceof PopularityRankData)) { _o_ = (PopularityRankData)_o1_;
/* 228 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 229 */       return false;
/* 230 */     if (!this.rank_data_list.equals(_o_.rank_data_list)) return false;
/* 231 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     int _h_ = 0;
/* 239 */     _h_ += this.rank_data_list.hashCode();
/* 240 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 246 */     _xdb_verify_unsafe_();
/* 247 */     StringBuilder _sb_ = new StringBuilder();
/* 248 */     _sb_.append("(");
/* 249 */     _sb_.append(this.rank_data_list);
/* 250 */     _sb_.append(")");
/* 251 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 257 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 258 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rank_data_list"));
/* 259 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PopularityRankData {
/*     */     private Const() {}
/*     */     
/*     */     PopularityRankData nThis() {
/* 266 */       return PopularityRankData.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 272 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PopularityRankData copy()
/*     */     {
/* 278 */       return PopularityRankData.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PopularityRankData toData()
/*     */     {
/* 284 */       return PopularityRankData.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PopularityRankData toBean()
/*     */     {
/* 289 */       return PopularityRankData.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PopularityRankData toDataIf()
/*     */     {
/* 295 */       return PopularityRankData.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PopularityRankData toBeanIf()
/*     */     {
/* 300 */       return PopularityRankData.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RolePopularityRankData> getRank_data_list()
/*     */     {
/* 307 */       PopularityRankData.this._xdb_verify_unsafe_();
/* 308 */       return xdb.Consts.constList(PopularityRankData.this.rank_data_list);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<xbean.RolePopularityRankData> getRank_data_listAsData()
/*     */     {
/* 314 */       PopularityRankData.this._xdb_verify_unsafe_();
/*     */       
/* 316 */       PopularityRankData _o_ = PopularityRankData.this;
/* 317 */       List<xbean.RolePopularityRankData> rank_data_list = new LinkedList();
/* 318 */       for (xbean.RolePopularityRankData _v_ : _o_.rank_data_list)
/* 319 */         rank_data_list.add(new RolePopularityRankData.Data(_v_));
/* 320 */       return rank_data_list;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 326 */       PopularityRankData.this._xdb_verify_unsafe_();
/* 327 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 333 */       PopularityRankData.this._xdb_verify_unsafe_();
/* 334 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 340 */       return PopularityRankData.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 346 */       return PopularityRankData.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 352 */       PopularityRankData.this._xdb_verify_unsafe_();
/* 353 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 359 */       return PopularityRankData.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 365 */       return PopularityRankData.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 371 */       PopularityRankData.this._xdb_verify_unsafe_();
/* 372 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 378 */       return PopularityRankData.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 384 */       return PopularityRankData.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 390 */       return PopularityRankData.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 396 */       return PopularityRankData.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 402 */       return PopularityRankData.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 408 */       return PopularityRankData.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 414 */       return PopularityRankData.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PopularityRankData
/*     */   {
/*     */     private LinkedList<xbean.RolePopularityRankData> rank_data_list;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 431 */       this.rank_data_list = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.PopularityRankData _o1_)
/*     */     {
/* 436 */       if ((_o1_ instanceof PopularityRankData)) { assign((PopularityRankData)_o1_);
/* 437 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 438 */       } else if ((_o1_ instanceof PopularityRankData.Const)) assign(((PopularityRankData.Const)_o1_).nThis()); else {
/* 439 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PopularityRankData _o_) {
/* 444 */       this.rank_data_list = new LinkedList();
/* 445 */       for (xbean.RolePopularityRankData _v_ : _o_.rank_data_list) {
/* 446 */         this.rank_data_list.add(new RolePopularityRankData.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 451 */       this.rank_data_list = new LinkedList();
/* 452 */       for (xbean.RolePopularityRankData _v_ : _o_.rank_data_list) {
/* 453 */         this.rank_data_list.add(new RolePopularityRankData.Data(_v_));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 459 */       _os_.compact_uint32(this.rank_data_list.size());
/* 460 */       for (xbean.RolePopularityRankData _v_ : this.rank_data_list)
/*     */       {
/* 462 */         _v_.marshal(_os_);
/*     */       }
/* 464 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 470 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 472 */         xbean.RolePopularityRankData _v_ = xbean.Pod.newRolePopularityRankDataData();
/* 473 */         _v_.unmarshal(_os_);
/* 474 */         this.rank_data_list.add(_v_);
/*     */       }
/* 476 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 482 */       int _size_ = 0;
/* 483 */       for (xbean.RolePopularityRankData _v_ : this.rank_data_list)
/*     */       {
/* 485 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*     */       }
/* 487 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 495 */         for (xbean.RolePopularityRankData _v_ : this.rank_data_list)
/*     */         {
/* 497 */           _output_.writeMessage(1, _v_);
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 502 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 504 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 512 */         boolean done = false;
/* 513 */         while (!done)
/*     */         {
/* 515 */           int tag = _input_.readTag();
/* 516 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 520 */             done = true;
/* 521 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 525 */             xbean.RolePopularityRankData _v_ = xbean.Pod.newRolePopularityRankDataData();
/* 526 */             _input_.readMessage(_v_);
/* 527 */             this.rank_data_list.add(_v_);
/* 528 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 532 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 534 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 543 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 547 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 549 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PopularityRankData copy()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PopularityRankData toData()
/*     */     {
/* 561 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PopularityRankData toBean()
/*     */     {
/* 566 */       return new PopularityRankData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PopularityRankData toDataIf()
/*     */     {
/* 572 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PopularityRankData toBeanIf()
/*     */     {
/* 577 */       return new PopularityRankData(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 587 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 591 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 595 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 599 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 603 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 607 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RolePopularityRankData> getRank_data_list()
/*     */     {
/* 614 */       return this.rank_data_list;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<xbean.RolePopularityRankData> getRank_data_listAsData()
/*     */     {
/* 621 */       return this.rank_data_list;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 627 */       if (!(_o1_ instanceof Data)) return false;
/* 628 */       Data _o_ = (Data)_o1_;
/* 629 */       if (!this.rank_data_list.equals(_o_.rank_data_list)) return false;
/* 630 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 636 */       int _h_ = 0;
/* 637 */       _h_ += this.rank_data_list.hashCode();
/* 638 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 644 */       StringBuilder _sb_ = new StringBuilder();
/* 645 */       _sb_.append("(");
/* 646 */       _sb_.append(this.rank_data_list);
/* 647 */       _sb_.append(")");
/* 648 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PopularityRankData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */