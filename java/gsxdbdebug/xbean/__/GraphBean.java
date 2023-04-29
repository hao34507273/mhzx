/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class GraphBean extends XBean implements xbean.GraphBean
/*     */ {
/*     */   private int graphid;
/*     */   private xbean.NodeBean nodebean;
/*     */   private int allfinishcount;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.graphid = 0;
/*  23 */     this.nodebean._reset_unsafe_();
/*  24 */     this.allfinishcount = 0;
/*     */   }
/*     */   
/*     */   GraphBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.nodebean = new NodeBean(0, this, "nodebean");
/*     */   }
/*     */   
/*     */   public GraphBean()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GraphBean(GraphBean _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GraphBean(xbean.GraphBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof GraphBean)) { assign((GraphBean)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GraphBean _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.graphid = _o_.graphid;
/*  56 */     this.nodebean = new NodeBean(_o_.nodebean, this, "nodebean");
/*  57 */     this.allfinishcount = _o_.allfinishcount;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.graphid = _o_.graphid;
/*  63 */     this.nodebean = new NodeBean(_o_.nodebean, this, "nodebean");
/*  64 */     this.allfinishcount = _o_.allfinishcount;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.graphid);
/*  72 */     this.nodebean.marshal(_os_);
/*  73 */     _os_.marshal(this.allfinishcount);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.graphid = _os_.unmarshal_int();
/*  82 */     this.nodebean.unmarshal(_os_);
/*  83 */     this.allfinishcount = _os_.unmarshal_int();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(1, this.graphid);
/*  93 */     _size_ += CodedOutputStream.computeMessageSize(2, this.nodebean);
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(3, this.allfinishcount);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt32(1, this.graphid);
/* 105 */       _output_.writeMessage(2, this.nodebean);
/* 106 */       _output_.writeInt32(3, this.allfinishcount);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.graphid = _input_.readInt32();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 18: 
/* 139 */           _input_.readMessage(this.nodebean);
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 144 */           this.allfinishcount = _input_.readInt32();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GraphBean copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new GraphBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GraphBean toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GraphBean toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new GraphBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GraphBean toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GraphBean toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getGraphid()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.graphid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public xbean.NodeBean getNodebean()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this.nodebean;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAllfinishcount()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return this.allfinishcount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setGraphid(int _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "graphid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new xdb.logs.LogInt(this, GraphBean.this.graphid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             GraphBean.this.graphid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.graphid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAllfinishcount(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "allfinishcount")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new xdb.logs.LogInt(this, GraphBean.this.allfinishcount)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             GraphBean.this.allfinishcount = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.allfinishcount = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     GraphBean _o_ = null;
/* 280 */     if ((_o1_ instanceof GraphBean)) { _o_ = (GraphBean)_o1_;
/* 281 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 282 */       return false;
/* 283 */     if (this.graphid != _o_.graphid) return false;
/* 284 */     if (!this.nodebean.equals(_o_.nodebean)) return false;
/* 285 */     if (this.allfinishcount != _o_.allfinishcount) return false;
/* 286 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 292 */     _xdb_verify_unsafe_();
/* 293 */     int _h_ = 0;
/* 294 */     _h_ += this.graphid;
/* 295 */     _h_ += this.nodebean.hashCode();
/* 296 */     _h_ += this.allfinishcount;
/* 297 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 303 */     _xdb_verify_unsafe_();
/* 304 */     StringBuilder _sb_ = new StringBuilder();
/* 305 */     _sb_.append("(");
/* 306 */     _sb_.append(this.graphid);
/* 307 */     _sb_.append(",");
/* 308 */     _sb_.append(this.nodebean);
/* 309 */     _sb_.append(",");
/* 310 */     _sb_.append(this.allfinishcount);
/* 311 */     _sb_.append(")");
/* 312 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 318 */     ListenableBean lb = new ListenableBean();
/* 319 */     lb.add(new ListenableChanged().setVarName("graphid"));
/* 320 */     lb.add(new ListenableChanged().setVarName("nodebean"));
/* 321 */     lb.add(new ListenableChanged().setVarName("allfinishcount"));
/* 322 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GraphBean {
/*     */     private Const() {}
/*     */     
/*     */     GraphBean nThis() {
/* 329 */       return GraphBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 335 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GraphBean copy()
/*     */     {
/* 341 */       return GraphBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GraphBean toData()
/*     */     {
/* 347 */       return GraphBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GraphBean toBean()
/*     */     {
/* 352 */       return GraphBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GraphBean toDataIf()
/*     */     {
/* 358 */       return GraphBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GraphBean toBeanIf()
/*     */     {
/* 363 */       return GraphBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGraphid()
/*     */     {
/* 370 */       GraphBean.this._xdb_verify_unsafe_();
/* 371 */       return GraphBean.this.graphid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.NodeBean getNodebean()
/*     */     {
/* 378 */       GraphBean.this._xdb_verify_unsafe_();
/* 379 */       return (xbean.NodeBean)xdb.Consts.toConst(GraphBean.this.nodebean);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAllfinishcount()
/*     */     {
/* 386 */       GraphBean.this._xdb_verify_unsafe_();
/* 387 */       return GraphBean.this.allfinishcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGraphid(int _v_)
/*     */     {
/* 394 */       GraphBean.this._xdb_verify_unsafe_();
/* 395 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAllfinishcount(int _v_)
/*     */     {
/* 402 */       GraphBean.this._xdb_verify_unsafe_();
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 409 */       GraphBean.this._xdb_verify_unsafe_();
/* 410 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 416 */       GraphBean.this._xdb_verify_unsafe_();
/* 417 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 423 */       return GraphBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 429 */       return GraphBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 435 */       GraphBean.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 442 */       return GraphBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 448 */       return GraphBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 454 */       GraphBean.this._xdb_verify_unsafe_();
/* 455 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 461 */       return GraphBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 467 */       return GraphBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 473 */       return GraphBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 479 */       return GraphBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 485 */       return GraphBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 491 */       return GraphBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 497 */       return GraphBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GraphBean
/*     */   {
/*     */     private int graphid;
/*     */     
/*     */     private xbean.NodeBean nodebean;
/*     */     
/*     */     private int allfinishcount;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 518 */       this.nodebean = new NodeBean.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.GraphBean _o1_)
/*     */     {
/* 523 */       if ((_o1_ instanceof GraphBean)) { assign((GraphBean)_o1_);
/* 524 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 525 */       } else if ((_o1_ instanceof GraphBean.Const)) assign(((GraphBean.Const)_o1_).nThis()); else {
/* 526 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GraphBean _o_) {
/* 531 */       this.graphid = _o_.graphid;
/* 532 */       this.nodebean = new NodeBean.Data(_o_.nodebean);
/* 533 */       this.allfinishcount = _o_.allfinishcount;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 538 */       this.graphid = _o_.graphid;
/* 539 */       this.nodebean = new NodeBean.Data(_o_.nodebean);
/* 540 */       this.allfinishcount = _o_.allfinishcount;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 546 */       _os_.marshal(this.graphid);
/* 547 */       this.nodebean.marshal(_os_);
/* 548 */       _os_.marshal(this.allfinishcount);
/* 549 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 555 */       this.graphid = _os_.unmarshal_int();
/* 556 */       this.nodebean.unmarshal(_os_);
/* 557 */       this.allfinishcount = _os_.unmarshal_int();
/* 558 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 564 */       int _size_ = 0;
/* 565 */       _size_ += CodedOutputStream.computeInt32Size(1, this.graphid);
/* 566 */       _size_ += CodedOutputStream.computeMessageSize(2, this.nodebean);
/* 567 */       _size_ += CodedOutputStream.computeInt32Size(3, this.allfinishcount);
/* 568 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 576 */         _output_.writeInt32(1, this.graphid);
/* 577 */         _output_.writeMessage(2, this.nodebean);
/* 578 */         _output_.writeInt32(3, this.allfinishcount);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 582 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 584 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 592 */         boolean done = false;
/* 593 */         while (!done)
/*     */         {
/* 595 */           int tag = _input_.readTag();
/* 596 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 600 */             done = true;
/* 601 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 605 */             this.graphid = _input_.readInt32();
/* 606 */             break;
/*     */           
/*     */ 
/*     */           case 18: 
/* 610 */             _input_.readMessage(this.nodebean);
/* 611 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 615 */             this.allfinishcount = _input_.readInt32();
/* 616 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 620 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 622 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 631 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 635 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 637 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GraphBean copy()
/*     */     {
/* 643 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GraphBean toData()
/*     */     {
/* 649 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GraphBean toBean()
/*     */     {
/* 654 */       return new GraphBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GraphBean toDataIf()
/*     */     {
/* 660 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GraphBean toBeanIf()
/*     */     {
/* 665 */       return new GraphBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 671 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 675 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 679 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 683 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 687 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 691 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 695 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGraphid()
/*     */     {
/* 702 */       return this.graphid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.NodeBean getNodebean()
/*     */     {
/* 709 */       return this.nodebean;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAllfinishcount()
/*     */     {
/* 716 */       return this.allfinishcount;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setGraphid(int _v_)
/*     */     {
/* 723 */       this.graphid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAllfinishcount(int _v_)
/*     */     {
/* 730 */       this.allfinishcount = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 736 */       if (!(_o1_ instanceof Data)) return false;
/* 737 */       Data _o_ = (Data)_o1_;
/* 738 */       if (this.graphid != _o_.graphid) return false;
/* 739 */       if (!this.nodebean.equals(_o_.nodebean)) return false;
/* 740 */       if (this.allfinishcount != _o_.allfinishcount) return false;
/* 741 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 747 */       int _h_ = 0;
/* 748 */       _h_ += this.graphid;
/* 749 */       _h_ += this.nodebean.hashCode();
/* 750 */       _h_ += this.allfinishcount;
/* 751 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 757 */       StringBuilder _sb_ = new StringBuilder();
/* 758 */       _sb_.append("(");
/* 759 */       _sb_.append(this.graphid);
/* 760 */       _sb_.append(",");
/* 761 */       _sb_.append(this.nodebean);
/* 762 */       _sb_.append(",");
/* 763 */       _sb_.append(this.allfinishcount);
/* 764 */       _sb_.append(")");
/* 765 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GraphBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */