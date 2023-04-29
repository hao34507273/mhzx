/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ 
/*      */ public final class FlowerPoint extends XBean implements xbean.FlowerPoint
/*      */ {
/*      */   private int receivepoint;
/*      */   private int givepoint;
/*      */   private long cleartime;
/*      */   private int version;
/*      */   private int total_receive_point;
/*      */   private int total_give_point;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.receivepoint = 0;
/*   29 */     this.givepoint = 0;
/*   30 */     this.cleartime = 0L;
/*   31 */     this.version = 0;
/*   32 */     this.total_receive_point = 0;
/*   33 */     this.total_give_point = 0;
/*      */   }
/*      */   
/*      */   FlowerPoint(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.receivepoint = 0;
/*   40 */     this.givepoint = 0;
/*   41 */     this.cleartime = 0L;
/*   42 */     this.version = 0;
/*   43 */     this.total_receive_point = 0;
/*   44 */     this.total_give_point = 0;
/*      */   }
/*      */   
/*      */   public FlowerPoint()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FlowerPoint(FlowerPoint _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FlowerPoint(xbean.FlowerPoint _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof FlowerPoint)) { assign((FlowerPoint)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FlowerPoint _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.receivepoint = _o_.receivepoint;
/*   70 */     this.givepoint = _o_.givepoint;
/*   71 */     this.cleartime = _o_.cleartime;
/*   72 */     this.version = _o_.version;
/*   73 */     this.total_receive_point = _o_.total_receive_point;
/*   74 */     this.total_give_point = _o_.total_give_point;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   79 */     this.receivepoint = _o_.receivepoint;
/*   80 */     this.givepoint = _o_.givepoint;
/*   81 */     this.cleartime = _o_.cleartime;
/*   82 */     this.version = _o_.version;
/*   83 */     this.total_receive_point = _o_.total_receive_point;
/*   84 */     this.total_give_point = _o_.total_give_point;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   90 */     _xdb_verify_unsafe_();
/*   91 */     _os_.marshal(this.receivepoint);
/*   92 */     _os_.marshal(this.givepoint);
/*   93 */     _os_.marshal(this.cleartime);
/*   94 */     _os_.marshal(this.version);
/*   95 */     _os_.marshal(this.total_receive_point);
/*   96 */     _os_.marshal(this.total_give_point);
/*   97 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  103 */     _xdb_verify_unsafe_();
/*  104 */     this.receivepoint = _os_.unmarshal_int();
/*  105 */     this.givepoint = _os_.unmarshal_int();
/*  106 */     this.cleartime = _os_.unmarshal_long();
/*  107 */     this.version = _os_.unmarshal_int();
/*  108 */     this.total_receive_point = _os_.unmarshal_int();
/*  109 */     this.total_give_point = _os_.unmarshal_int();
/*  110 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  116 */     _xdb_verify_unsafe_();
/*  117 */     int _size_ = 0;
/*  118 */     _size_ += CodedOutputStream.computeInt32Size(1, this.receivepoint);
/*  119 */     _size_ += CodedOutputStream.computeInt32Size(2, this.givepoint);
/*  120 */     _size_ += CodedOutputStream.computeInt64Size(3, this.cleartime);
/*  121 */     _size_ += CodedOutputStream.computeInt32Size(4, this.version);
/*  122 */     _size_ += CodedOutputStream.computeInt32Size(5, this.total_receive_point);
/*  123 */     _size_ += CodedOutputStream.computeInt32Size(6, this.total_give_point);
/*  124 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  130 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  133 */       _output_.writeInt32(1, this.receivepoint);
/*  134 */       _output_.writeInt32(2, this.givepoint);
/*  135 */       _output_.writeInt64(3, this.cleartime);
/*  136 */       _output_.writeInt32(4, this.version);
/*  137 */       _output_.writeInt32(5, this.total_receive_point);
/*  138 */       _output_.writeInt32(6, this.total_give_point);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  142 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  144 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  150 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  153 */       boolean done = false;
/*  154 */       while (!done)
/*      */       {
/*  156 */         int tag = _input_.readTag();
/*  157 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  161 */           done = true;
/*  162 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  166 */           this.receivepoint = _input_.readInt32();
/*  167 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  171 */           this.givepoint = _input_.readInt32();
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  176 */           this.cleartime = _input_.readInt64();
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  181 */           this.version = _input_.readInt32();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  186 */           this.total_receive_point = _input_.readInt32();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  191 */           this.total_give_point = _input_.readInt32();
/*  192 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  196 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  198 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  207 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  211 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  213 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FlowerPoint copy()
/*      */   {
/*  219 */     _xdb_verify_unsafe_();
/*  220 */     return new FlowerPoint(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FlowerPoint toData()
/*      */   {
/*  226 */     _xdb_verify_unsafe_();
/*  227 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FlowerPoint toBean()
/*      */   {
/*  232 */     _xdb_verify_unsafe_();
/*  233 */     return new FlowerPoint(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FlowerPoint toDataIf()
/*      */   {
/*  239 */     _xdb_verify_unsafe_();
/*  240 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FlowerPoint toBeanIf()
/*      */   {
/*  245 */     _xdb_verify_unsafe_();
/*  246 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  252 */     _xdb_verify_unsafe_();
/*  253 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getReceivepoint()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return this.receivepoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGivepoint()
/*      */   {
/*  268 */     _xdb_verify_unsafe_();
/*  269 */     return this.givepoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCleartime()
/*      */   {
/*  276 */     _xdb_verify_unsafe_();
/*  277 */     return this.cleartime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVersion()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return this.version;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotal_receive_point()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return this.total_receive_point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotal_give_point()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return this.total_give_point;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReceivepoint(int _v_)
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     Logs.logIf(new LogKey(this, "receivepoint")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  313 */         new LogInt(this, FlowerPoint.this.receivepoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  317 */             FlowerPoint.this.receivepoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  321 */     });
/*  322 */     this.receivepoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGivepoint(int _v_)
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     Logs.logIf(new LogKey(this, "givepoint")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  334 */         new LogInt(this, FlowerPoint.this.givepoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  338 */             FlowerPoint.this.givepoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  342 */     });
/*  343 */     this.givepoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCleartime(long _v_)
/*      */   {
/*  350 */     _xdb_verify_unsafe_();
/*  351 */     Logs.logIf(new LogKey(this, "cleartime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  355 */         new xdb.logs.LogLong(this, FlowerPoint.this.cleartime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  359 */             FlowerPoint.this.cleartime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  363 */     });
/*  364 */     this.cleartime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVersion(int _v_)
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     Logs.logIf(new LogKey(this, "version")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  376 */         new LogInt(this, FlowerPoint.this.version)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  380 */             FlowerPoint.this.version = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  384 */     });
/*  385 */     this.version = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_receive_point(int _v_)
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     Logs.logIf(new LogKey(this, "total_receive_point")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  397 */         new LogInt(this, FlowerPoint.this.total_receive_point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  401 */             FlowerPoint.this.total_receive_point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  405 */     });
/*  406 */     this.total_receive_point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotal_give_point(int _v_)
/*      */   {
/*  413 */     _xdb_verify_unsafe_();
/*  414 */     Logs.logIf(new LogKey(this, "total_give_point")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  418 */         new LogInt(this, FlowerPoint.this.total_give_point)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  422 */             FlowerPoint.this.total_give_point = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  426 */     });
/*  427 */     this.total_give_point = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     FlowerPoint _o_ = null;
/*  435 */     if ((_o1_ instanceof FlowerPoint)) { _o_ = (FlowerPoint)_o1_;
/*  436 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  437 */       return false;
/*  438 */     if (this.receivepoint != _o_.receivepoint) return false;
/*  439 */     if (this.givepoint != _o_.givepoint) return false;
/*  440 */     if (this.cleartime != _o_.cleartime) return false;
/*  441 */     if (this.version != _o_.version) return false;
/*  442 */     if (this.total_receive_point != _o_.total_receive_point) return false;
/*  443 */     if (this.total_give_point != _o_.total_give_point) return false;
/*  444 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  450 */     _xdb_verify_unsafe_();
/*  451 */     int _h_ = 0;
/*  452 */     _h_ += this.receivepoint;
/*  453 */     _h_ += this.givepoint;
/*  454 */     _h_ = (int)(_h_ + this.cleartime);
/*  455 */     _h_ += this.version;
/*  456 */     _h_ += this.total_receive_point;
/*  457 */     _h_ += this.total_give_point;
/*  458 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  464 */     _xdb_verify_unsafe_();
/*  465 */     StringBuilder _sb_ = new StringBuilder();
/*  466 */     _sb_.append("(");
/*  467 */     _sb_.append(this.receivepoint);
/*  468 */     _sb_.append(",");
/*  469 */     _sb_.append(this.givepoint);
/*  470 */     _sb_.append(",");
/*  471 */     _sb_.append(this.cleartime);
/*  472 */     _sb_.append(",");
/*  473 */     _sb_.append(this.version);
/*  474 */     _sb_.append(",");
/*  475 */     _sb_.append(this.total_receive_point);
/*  476 */     _sb_.append(",");
/*  477 */     _sb_.append(this.total_give_point);
/*  478 */     _sb_.append(")");
/*  479 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  485 */     ListenableBean lb = new ListenableBean();
/*  486 */     lb.add(new ListenableChanged().setVarName("receivepoint"));
/*  487 */     lb.add(new ListenableChanged().setVarName("givepoint"));
/*  488 */     lb.add(new ListenableChanged().setVarName("cleartime"));
/*  489 */     lb.add(new ListenableChanged().setVarName("version"));
/*  490 */     lb.add(new ListenableChanged().setVarName("total_receive_point"));
/*  491 */     lb.add(new ListenableChanged().setVarName("total_give_point"));
/*  492 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FlowerPoint {
/*      */     private Const() {}
/*      */     
/*      */     FlowerPoint nThis() {
/*  499 */       return FlowerPoint.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  505 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerPoint copy()
/*      */     {
/*  511 */       return FlowerPoint.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerPoint toData()
/*      */     {
/*  517 */       return FlowerPoint.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FlowerPoint toBean()
/*      */     {
/*  522 */       return FlowerPoint.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerPoint toDataIf()
/*      */     {
/*  528 */       return FlowerPoint.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FlowerPoint toBeanIf()
/*      */     {
/*  533 */       return FlowerPoint.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReceivepoint()
/*      */     {
/*  540 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  541 */       return FlowerPoint.this.receivepoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGivepoint()
/*      */     {
/*  548 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  549 */       return FlowerPoint.this.givepoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCleartime()
/*      */     {
/*  556 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  557 */       return FlowerPoint.this.cleartime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVersion()
/*      */     {
/*  564 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  565 */       return FlowerPoint.this.version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_receive_point()
/*      */     {
/*  572 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  573 */       return FlowerPoint.this.total_receive_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_give_point()
/*      */     {
/*  580 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  581 */       return FlowerPoint.this.total_give_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReceivepoint(int _v_)
/*      */     {
/*  588 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  589 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGivepoint(int _v_)
/*      */     {
/*  596 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  597 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleartime(long _v_)
/*      */     {
/*  604 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  605 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVersion(int _v_)
/*      */     {
/*  612 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  613 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_receive_point(int _v_)
/*      */     {
/*  620 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  621 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_give_point(int _v_)
/*      */     {
/*  628 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  629 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  635 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  636 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  642 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  643 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  649 */       return FlowerPoint.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  655 */       return FlowerPoint.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  661 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  662 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  668 */       return FlowerPoint.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  674 */       return FlowerPoint.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  680 */       FlowerPoint.this._xdb_verify_unsafe_();
/*  681 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  687 */       return FlowerPoint.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  693 */       return FlowerPoint.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  699 */       return FlowerPoint.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  705 */       return FlowerPoint.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  711 */       return FlowerPoint.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  717 */       return FlowerPoint.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  723 */       return FlowerPoint.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FlowerPoint
/*      */   {
/*      */     private int receivepoint;
/*      */     
/*      */     private int givepoint;
/*      */     
/*      */     private long cleartime;
/*      */     
/*      */     private int version;
/*      */     
/*      */     private int total_receive_point;
/*      */     
/*      */     private int total_give_point;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  745 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  750 */       this.receivepoint = 0;
/*  751 */       this.givepoint = 0;
/*  752 */       this.cleartime = 0L;
/*  753 */       this.version = 0;
/*  754 */       this.total_receive_point = 0;
/*  755 */       this.total_give_point = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.FlowerPoint _o1_)
/*      */     {
/*  760 */       if ((_o1_ instanceof FlowerPoint)) { assign((FlowerPoint)_o1_);
/*  761 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  762 */       } else if ((_o1_ instanceof FlowerPoint.Const)) assign(((FlowerPoint.Const)_o1_).nThis()); else {
/*  763 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FlowerPoint _o_) {
/*  768 */       this.receivepoint = _o_.receivepoint;
/*  769 */       this.givepoint = _o_.givepoint;
/*  770 */       this.cleartime = _o_.cleartime;
/*  771 */       this.version = _o_.version;
/*  772 */       this.total_receive_point = _o_.total_receive_point;
/*  773 */       this.total_give_point = _o_.total_give_point;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  778 */       this.receivepoint = _o_.receivepoint;
/*  779 */       this.givepoint = _o_.givepoint;
/*  780 */       this.cleartime = _o_.cleartime;
/*  781 */       this.version = _o_.version;
/*  782 */       this.total_receive_point = _o_.total_receive_point;
/*  783 */       this.total_give_point = _o_.total_give_point;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  789 */       _os_.marshal(this.receivepoint);
/*  790 */       _os_.marshal(this.givepoint);
/*  791 */       _os_.marshal(this.cleartime);
/*  792 */       _os_.marshal(this.version);
/*  793 */       _os_.marshal(this.total_receive_point);
/*  794 */       _os_.marshal(this.total_give_point);
/*  795 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  801 */       this.receivepoint = _os_.unmarshal_int();
/*  802 */       this.givepoint = _os_.unmarshal_int();
/*  803 */       this.cleartime = _os_.unmarshal_long();
/*  804 */       this.version = _os_.unmarshal_int();
/*  805 */       this.total_receive_point = _os_.unmarshal_int();
/*  806 */       this.total_give_point = _os_.unmarshal_int();
/*  807 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  813 */       int _size_ = 0;
/*  814 */       _size_ += CodedOutputStream.computeInt32Size(1, this.receivepoint);
/*  815 */       _size_ += CodedOutputStream.computeInt32Size(2, this.givepoint);
/*  816 */       _size_ += CodedOutputStream.computeInt64Size(3, this.cleartime);
/*  817 */       _size_ += CodedOutputStream.computeInt32Size(4, this.version);
/*  818 */       _size_ += CodedOutputStream.computeInt32Size(5, this.total_receive_point);
/*  819 */       _size_ += CodedOutputStream.computeInt32Size(6, this.total_give_point);
/*  820 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  828 */         _output_.writeInt32(1, this.receivepoint);
/*  829 */         _output_.writeInt32(2, this.givepoint);
/*  830 */         _output_.writeInt64(3, this.cleartime);
/*  831 */         _output_.writeInt32(4, this.version);
/*  832 */         _output_.writeInt32(5, this.total_receive_point);
/*  833 */         _output_.writeInt32(6, this.total_give_point);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  837 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  839 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  847 */         boolean done = false;
/*  848 */         while (!done)
/*      */         {
/*  850 */           int tag = _input_.readTag();
/*  851 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  855 */             done = true;
/*  856 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  860 */             this.receivepoint = _input_.readInt32();
/*  861 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  865 */             this.givepoint = _input_.readInt32();
/*  866 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  870 */             this.cleartime = _input_.readInt64();
/*  871 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  875 */             this.version = _input_.readInt32();
/*  876 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  880 */             this.total_receive_point = _input_.readInt32();
/*  881 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  885 */             this.total_give_point = _input_.readInt32();
/*  886 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  890 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  892 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  901 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  905 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  907 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerPoint copy()
/*      */     {
/*  913 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerPoint toData()
/*      */     {
/*  919 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FlowerPoint toBean()
/*      */     {
/*  924 */       return new FlowerPoint(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FlowerPoint toDataIf()
/*      */     {
/*  930 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FlowerPoint toBeanIf()
/*      */     {
/*  935 */       return new FlowerPoint(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  949 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  953 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  957 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  961 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  965 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReceivepoint()
/*      */     {
/*  972 */       return this.receivepoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGivepoint()
/*      */     {
/*  979 */       return this.givepoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCleartime()
/*      */     {
/*  986 */       return this.cleartime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVersion()
/*      */     {
/*  993 */       return this.version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_receive_point()
/*      */     {
/* 1000 */       return this.total_receive_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotal_give_point()
/*      */     {
/* 1007 */       return this.total_give_point;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReceivepoint(int _v_)
/*      */     {
/* 1014 */       this.receivepoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGivepoint(int _v_)
/*      */     {
/* 1021 */       this.givepoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleartime(long _v_)
/*      */     {
/* 1028 */       this.cleartime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVersion(int _v_)
/*      */     {
/* 1035 */       this.version = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_receive_point(int _v_)
/*      */     {
/* 1042 */       this.total_receive_point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotal_give_point(int _v_)
/*      */     {
/* 1049 */       this.total_give_point = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1055 */       if (!(_o1_ instanceof Data)) return false;
/* 1056 */       Data _o_ = (Data)_o1_;
/* 1057 */       if (this.receivepoint != _o_.receivepoint) return false;
/* 1058 */       if (this.givepoint != _o_.givepoint) return false;
/* 1059 */       if (this.cleartime != _o_.cleartime) return false;
/* 1060 */       if (this.version != _o_.version) return false;
/* 1061 */       if (this.total_receive_point != _o_.total_receive_point) return false;
/* 1062 */       if (this.total_give_point != _o_.total_give_point) return false;
/* 1063 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1069 */       int _h_ = 0;
/* 1070 */       _h_ += this.receivepoint;
/* 1071 */       _h_ += this.givepoint;
/* 1072 */       _h_ = (int)(_h_ + this.cleartime);
/* 1073 */       _h_ += this.version;
/* 1074 */       _h_ += this.total_receive_point;
/* 1075 */       _h_ += this.total_give_point;
/* 1076 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1082 */       StringBuilder _sb_ = new StringBuilder();
/* 1083 */       _sb_.append("(");
/* 1084 */       _sb_.append(this.receivepoint);
/* 1085 */       _sb_.append(",");
/* 1086 */       _sb_.append(this.givepoint);
/* 1087 */       _sb_.append(",");
/* 1088 */       _sb_.append(this.cleartime);
/* 1089 */       _sb_.append(",");
/* 1090 */       _sb_.append(this.version);
/* 1091 */       _sb_.append(",");
/* 1092 */       _sb_.append(this.total_receive_point);
/* 1093 */       _sb_.append(",");
/* 1094 */       _sb_.append(this.total_give_point);
/* 1095 */       _sb_.append(")");
/* 1096 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FlowerPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */