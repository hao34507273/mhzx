/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class Paraselene extends XBean implements xbean.Paraselene
/*      */ {
/*      */   private long starttime;
/*      */   private long finishtime;
/*      */   private int recentlayer;
/*      */   private boolean isinfuben;
/*      */   private ArrayList<Integer> layers;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.starttime = 0L;
/*   27 */     this.finishtime = 0L;
/*   28 */     this.recentlayer = 0;
/*   29 */     this.isinfuben = false;
/*   30 */     this.layers.clear();
/*      */   }
/*      */   
/*      */   Paraselene(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.recentlayer = 0;
/*   37 */     this.isinfuben = false;
/*   38 */     this.layers = new ArrayList();
/*      */   }
/*      */   
/*      */   public Paraselene()
/*      */   {
/*   43 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Paraselene(Paraselene _o_)
/*      */   {
/*   48 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Paraselene(xbean.Paraselene _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   53 */     super(_xp_, _vn_);
/*   54 */     if ((_o1_ instanceof Paraselene)) { assign((Paraselene)_o1_);
/*   55 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   56 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   57 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Paraselene _o_) {
/*   62 */     _o_._xdb_verify_unsafe_();
/*   63 */     this.starttime = _o_.starttime;
/*   64 */     this.finishtime = _o_.finishtime;
/*   65 */     this.recentlayer = _o_.recentlayer;
/*   66 */     this.isinfuben = _o_.isinfuben;
/*   67 */     this.layers = new ArrayList();
/*   68 */     this.layers.addAll(_o_.layers);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   73 */     this.starttime = _o_.starttime;
/*   74 */     this.finishtime = _o_.finishtime;
/*   75 */     this.recentlayer = _o_.recentlayer;
/*   76 */     this.isinfuben = _o_.isinfuben;
/*   77 */     this.layers = new ArrayList();
/*   78 */     this.layers.addAll(_o_.layers);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.starttime);
/*   86 */     _os_.marshal(this.finishtime);
/*   87 */     _os_.marshal(this.recentlayer);
/*   88 */     _os_.marshal(this.isinfuben);
/*   89 */     _os_.compact_uint32(this.layers.size());
/*   90 */     for (Integer _v_ : this.layers)
/*      */     {
/*   92 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   94 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  100 */     _xdb_verify_unsafe_();
/*  101 */     this.starttime = _os_.unmarshal_long();
/*  102 */     this.finishtime = _os_.unmarshal_long();
/*  103 */     this.recentlayer = _os_.unmarshal_int();
/*  104 */     this.isinfuben = _os_.unmarshal_boolean();
/*  105 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  107 */       int _v_ = 0;
/*  108 */       _v_ = _os_.unmarshal_int();
/*  109 */       this.layers.add(Integer.valueOf(_v_));
/*      */     }
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     int _size_ = 0;
/*  119 */     _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/*  120 */     _size_ += CodedOutputStream.computeInt64Size(2, this.finishtime);
/*  121 */     _size_ += CodedOutputStream.computeInt32Size(3, this.recentlayer);
/*  122 */     _size_ += CodedOutputStream.computeBoolSize(4, this.isinfuben);
/*  123 */     for (Integer _v_ : this.layers)
/*      */     {
/*  125 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  127 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  133 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  136 */       _output_.writeInt64(1, this.starttime);
/*  137 */       _output_.writeInt64(2, this.finishtime);
/*  138 */       _output_.writeInt32(3, this.recentlayer);
/*  139 */       _output_.writeBool(4, this.isinfuben);
/*  140 */       for (Integer _v_ : this.layers)
/*      */       {
/*  142 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  147 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  149 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  155 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  158 */       boolean done = false;
/*  159 */       while (!done)
/*      */       {
/*  161 */         int tag = _input_.readTag();
/*  162 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  166 */           done = true;
/*  167 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  171 */           this.starttime = _input_.readInt64();
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  176 */           this.finishtime = _input_.readInt64();
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  181 */           this.recentlayer = _input_.readInt32();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  186 */           this.isinfuben = _input_.readBool();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  191 */           int _v_ = 0;
/*  192 */           _v_ = _input_.readInt32();
/*  193 */           this.layers.add(Integer.valueOf(_v_));
/*  194 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  198 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  200 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  209 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  213 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  215 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Paraselene copy()
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*  222 */     return new Paraselene(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Paraselene toData()
/*      */   {
/*  228 */     _xdb_verify_unsafe_();
/*  229 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Paraselene toBean()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new Paraselene(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Paraselene toDataIf()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Paraselene toBeanIf()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStarttime()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return this.starttime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFinishtime()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return this.finishtime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRecentlayer()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return this.recentlayer;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIsinfuben()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return this.isinfuben;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getLayers()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return xdb.Logs.logList(new LogKey(this, "layers"), this.layers);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getLayersAsData()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*      */     
/*  303 */     Paraselene _o_ = this;
/*  304 */     List<Integer> layers = new ArrayList();
/*  305 */     layers.addAll(_o_.layers);
/*  306 */     return layers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStarttime(long _v_)
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     xdb.Logs.logIf(new LogKey(this, "starttime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  318 */         new xdb.logs.LogLong(this, Paraselene.this.starttime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  322 */             Paraselene.this.starttime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  326 */     });
/*  327 */     this.starttime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFinishtime(long _v_)
/*      */   {
/*  334 */     _xdb_verify_unsafe_();
/*  335 */     xdb.Logs.logIf(new LogKey(this, "finishtime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  339 */         new xdb.logs.LogLong(this, Paraselene.this.finishtime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  343 */             Paraselene.this.finishtime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  347 */     });
/*  348 */     this.finishtime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRecentlayer(int _v_)
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     xdb.Logs.logIf(new LogKey(this, "recentlayer")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  360 */         new xdb.logs.LogInt(this, Paraselene.this.recentlayer)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  364 */             Paraselene.this.recentlayer = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  368 */     });
/*  369 */     this.recentlayer = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsinfuben(boolean _v_)
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     xdb.Logs.logIf(new LogKey(this, "isinfuben")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  381 */         new xdb.logs.LogObject(this, Boolean.valueOf(Paraselene.this.isinfuben))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  385 */             Paraselene.this.isinfuben = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  389 */     });
/*  390 */     this.isinfuben = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  396 */     _xdb_verify_unsafe_();
/*  397 */     Paraselene _o_ = null;
/*  398 */     if ((_o1_ instanceof Paraselene)) { _o_ = (Paraselene)_o1_;
/*  399 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  400 */       return false;
/*  401 */     if (this.starttime != _o_.starttime) return false;
/*  402 */     if (this.finishtime != _o_.finishtime) return false;
/*  403 */     if (this.recentlayer != _o_.recentlayer) return false;
/*  404 */     if (this.isinfuben != _o_.isinfuben) return false;
/*  405 */     if (!this.layers.equals(_o_.layers)) return false;
/*  406 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     int _h_ = 0;
/*  414 */     _h_ = (int)(_h_ + this.starttime);
/*  415 */     _h_ = (int)(_h_ + this.finishtime);
/*  416 */     _h_ += this.recentlayer;
/*  417 */     _h_ += (this.isinfuben ? 1231 : 1237);
/*  418 */     _h_ += this.layers.hashCode();
/*  419 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     StringBuilder _sb_ = new StringBuilder();
/*  427 */     _sb_.append("(");
/*  428 */     _sb_.append(this.starttime);
/*  429 */     _sb_.append(",");
/*  430 */     _sb_.append(this.finishtime);
/*  431 */     _sb_.append(",");
/*  432 */     _sb_.append(this.recentlayer);
/*  433 */     _sb_.append(",");
/*  434 */     _sb_.append(this.isinfuben);
/*  435 */     _sb_.append(",");
/*  436 */     _sb_.append(this.layers);
/*  437 */     _sb_.append(")");
/*  438 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  444 */     ListenableBean lb = new ListenableBean();
/*  445 */     lb.add(new ListenableChanged().setVarName("starttime"));
/*  446 */     lb.add(new ListenableChanged().setVarName("finishtime"));
/*  447 */     lb.add(new ListenableChanged().setVarName("recentlayer"));
/*  448 */     lb.add(new ListenableChanged().setVarName("isinfuben"));
/*  449 */     lb.add(new ListenableChanged().setVarName("layers"));
/*  450 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Paraselene {
/*      */     private Const() {}
/*      */     
/*      */     Paraselene nThis() {
/*  457 */       return Paraselene.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  463 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Paraselene copy()
/*      */     {
/*  469 */       return Paraselene.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Paraselene toData()
/*      */     {
/*  475 */       return Paraselene.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Paraselene toBean()
/*      */     {
/*  480 */       return Paraselene.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Paraselene toDataIf()
/*      */     {
/*  486 */       return Paraselene.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Paraselene toBeanIf()
/*      */     {
/*  491 */       return Paraselene.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  498 */       Paraselene.this._xdb_verify_unsafe_();
/*  499 */       return Paraselene.this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFinishtime()
/*      */     {
/*  506 */       Paraselene.this._xdb_verify_unsafe_();
/*  507 */       return Paraselene.this.finishtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecentlayer()
/*      */     {
/*  514 */       Paraselene.this._xdb_verify_unsafe_();
/*  515 */       return Paraselene.this.recentlayer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsinfuben()
/*      */     {
/*  522 */       Paraselene.this._xdb_verify_unsafe_();
/*  523 */       return Paraselene.this.isinfuben;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getLayers()
/*      */     {
/*  530 */       Paraselene.this._xdb_verify_unsafe_();
/*  531 */       return xdb.Consts.constList(Paraselene.this.layers);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getLayersAsData()
/*      */     {
/*  537 */       Paraselene.this._xdb_verify_unsafe_();
/*      */       
/*  539 */       Paraselene _o_ = Paraselene.this;
/*  540 */       List<Integer> layers = new ArrayList();
/*  541 */       layers.addAll(_o_.layers);
/*  542 */       return layers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  549 */       Paraselene.this._xdb_verify_unsafe_();
/*  550 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinishtime(long _v_)
/*      */     {
/*  557 */       Paraselene.this._xdb_verify_unsafe_();
/*  558 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecentlayer(int _v_)
/*      */     {
/*  565 */       Paraselene.this._xdb_verify_unsafe_();
/*  566 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsinfuben(boolean _v_)
/*      */     {
/*  573 */       Paraselene.this._xdb_verify_unsafe_();
/*  574 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  580 */       Paraselene.this._xdb_verify_unsafe_();
/*  581 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  587 */       Paraselene.this._xdb_verify_unsafe_();
/*  588 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  594 */       return Paraselene.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  600 */       return Paraselene.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  606 */       Paraselene.this._xdb_verify_unsafe_();
/*  607 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  613 */       return Paraselene.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  619 */       return Paraselene.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  625 */       Paraselene.this._xdb_verify_unsafe_();
/*  626 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  632 */       return Paraselene.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  638 */       return Paraselene.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  644 */       return Paraselene.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  650 */       return Paraselene.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  656 */       return Paraselene.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  662 */       return Paraselene.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  668 */       return Paraselene.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Paraselene
/*      */   {
/*      */     private long starttime;
/*      */     
/*      */     private long finishtime;
/*      */     
/*      */     private int recentlayer;
/*      */     
/*      */     private boolean isinfuben;
/*      */     
/*      */     private ArrayList<Integer> layers;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  688 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  693 */       this.recentlayer = 0;
/*  694 */       this.isinfuben = false;
/*  695 */       this.layers = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.Paraselene _o1_)
/*      */     {
/*  700 */       if ((_o1_ instanceof Paraselene)) { assign((Paraselene)_o1_);
/*  701 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  702 */       } else if ((_o1_ instanceof Paraselene.Const)) assign(((Paraselene.Const)_o1_).nThis()); else {
/*  703 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Paraselene _o_) {
/*  708 */       this.starttime = _o_.starttime;
/*  709 */       this.finishtime = _o_.finishtime;
/*  710 */       this.recentlayer = _o_.recentlayer;
/*  711 */       this.isinfuben = _o_.isinfuben;
/*  712 */       this.layers = new ArrayList();
/*  713 */       this.layers.addAll(_o_.layers);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  718 */       this.starttime = _o_.starttime;
/*  719 */       this.finishtime = _o_.finishtime;
/*  720 */       this.recentlayer = _o_.recentlayer;
/*  721 */       this.isinfuben = _o_.isinfuben;
/*  722 */       this.layers = new ArrayList();
/*  723 */       this.layers.addAll(_o_.layers);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  729 */       _os_.marshal(this.starttime);
/*  730 */       _os_.marshal(this.finishtime);
/*  731 */       _os_.marshal(this.recentlayer);
/*  732 */       _os_.marshal(this.isinfuben);
/*  733 */       _os_.compact_uint32(this.layers.size());
/*  734 */       for (Integer _v_ : this.layers)
/*      */       {
/*  736 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  738 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  744 */       this.starttime = _os_.unmarshal_long();
/*  745 */       this.finishtime = _os_.unmarshal_long();
/*  746 */       this.recentlayer = _os_.unmarshal_int();
/*  747 */       this.isinfuben = _os_.unmarshal_boolean();
/*  748 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  750 */         int _v_ = 0;
/*  751 */         _v_ = _os_.unmarshal_int();
/*  752 */         this.layers.add(Integer.valueOf(_v_));
/*      */       }
/*  754 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  760 */       int _size_ = 0;
/*  761 */       _size_ += CodedOutputStream.computeInt64Size(1, this.starttime);
/*  762 */       _size_ += CodedOutputStream.computeInt64Size(2, this.finishtime);
/*  763 */       _size_ += CodedOutputStream.computeInt32Size(3, this.recentlayer);
/*  764 */       _size_ += CodedOutputStream.computeBoolSize(4, this.isinfuben);
/*  765 */       for (Integer _v_ : this.layers)
/*      */       {
/*  767 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/*  769 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  777 */         _output_.writeInt64(1, this.starttime);
/*  778 */         _output_.writeInt64(2, this.finishtime);
/*  779 */         _output_.writeInt32(3, this.recentlayer);
/*  780 */         _output_.writeBool(4, this.isinfuben);
/*  781 */         for (Integer _v_ : this.layers)
/*      */         {
/*  783 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  788 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  790 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  798 */         boolean done = false;
/*  799 */         while (!done)
/*      */         {
/*  801 */           int tag = _input_.readTag();
/*  802 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  806 */             done = true;
/*  807 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  811 */             this.starttime = _input_.readInt64();
/*  812 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  816 */             this.finishtime = _input_.readInt64();
/*  817 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  821 */             this.recentlayer = _input_.readInt32();
/*  822 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  826 */             this.isinfuben = _input_.readBool();
/*  827 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  831 */             int _v_ = 0;
/*  832 */             _v_ = _input_.readInt32();
/*  833 */             this.layers.add(Integer.valueOf(_v_));
/*  834 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  838 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  840 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  849 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  853 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  855 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Paraselene copy()
/*      */     {
/*  861 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Paraselene toData()
/*      */     {
/*  867 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Paraselene toBean()
/*      */     {
/*  872 */       return new Paraselene(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Paraselene toDataIf()
/*      */     {
/*  878 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Paraselene toBeanIf()
/*      */     {
/*  883 */       return new Paraselene(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  889 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  893 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  897 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  901 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  905 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  909 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  913 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStarttime()
/*      */     {
/*  920 */       return this.starttime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFinishtime()
/*      */     {
/*  927 */       return this.finishtime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRecentlayer()
/*      */     {
/*  934 */       return this.recentlayer;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsinfuben()
/*      */     {
/*  941 */       return this.isinfuben;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getLayers()
/*      */     {
/*  948 */       return this.layers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getLayersAsData()
/*      */     {
/*  955 */       return this.layers;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStarttime(long _v_)
/*      */     {
/*  962 */       this.starttime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFinishtime(long _v_)
/*      */     {
/*  969 */       this.finishtime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRecentlayer(int _v_)
/*      */     {
/*  976 */       this.recentlayer = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsinfuben(boolean _v_)
/*      */     {
/*  983 */       this.isinfuben = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/*  989 */       if (!(_o1_ instanceof Data)) return false;
/*  990 */       Data _o_ = (Data)_o1_;
/*  991 */       if (this.starttime != _o_.starttime) return false;
/*  992 */       if (this.finishtime != _o_.finishtime) return false;
/*  993 */       if (this.recentlayer != _o_.recentlayer) return false;
/*  994 */       if (this.isinfuben != _o_.isinfuben) return false;
/*  995 */       if (!this.layers.equals(_o_.layers)) return false;
/*  996 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1002 */       int _h_ = 0;
/* 1003 */       _h_ = (int)(_h_ + this.starttime);
/* 1004 */       _h_ = (int)(_h_ + this.finishtime);
/* 1005 */       _h_ += this.recentlayer;
/* 1006 */       _h_ += (this.isinfuben ? 1231 : 1237);
/* 1007 */       _h_ += this.layers.hashCode();
/* 1008 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1014 */       StringBuilder _sb_ = new StringBuilder();
/* 1015 */       _sb_.append("(");
/* 1016 */       _sb_.append(this.starttime);
/* 1017 */       _sb_.append(",");
/* 1018 */       _sb_.append(this.finishtime);
/* 1019 */       _sb_.append(",");
/* 1020 */       _sb_.append(this.recentlayer);
/* 1021 */       _sb_.append(",");
/* 1022 */       _sb_.append(this.isinfuben);
/* 1023 */       _sb_.append(",");
/* 1024 */       _sb_.append(this.layers);
/* 1025 */       _sb_.append(")");
/* 1026 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Paraselene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */