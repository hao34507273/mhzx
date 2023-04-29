/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class TitleAppellation extends XBean implements xbean.TitleAppellation
/*      */ {
/*      */   private ArrayList<xbean.TitleInfo> owntitle;
/*      */   private int activetitle;
/*      */   private int activeappellation;
/*      */   private int pro2appellationid;
/*      */   private HashMap<Integer, xbean.AppellationInfo> appellations;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   26 */     this.owntitle.clear();
/*   27 */     this.activetitle = 0;
/*   28 */     this.activeappellation = 0;
/*   29 */     this.pro2appellationid = 0;
/*   30 */     this.appellations.clear();
/*      */   }
/*      */   
/*      */   TitleAppellation(int __, XBean _xp_, String _vn_)
/*      */   {
/*   35 */     super(_xp_, _vn_);
/*   36 */     this.owntitle = new ArrayList();
/*   37 */     this.appellations = new HashMap();
/*      */   }
/*      */   
/*      */   public TitleAppellation()
/*      */   {
/*   42 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public TitleAppellation(TitleAppellation _o_)
/*      */   {
/*   47 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   TitleAppellation(xbean.TitleAppellation _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   52 */     super(_xp_, _vn_);
/*   53 */     if ((_o1_ instanceof TitleAppellation)) { assign((TitleAppellation)_o1_);
/*   54 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   55 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   56 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(TitleAppellation _o_) {
/*   61 */     _o_._xdb_verify_unsafe_();
/*   62 */     this.owntitle = new ArrayList();
/*   63 */     for (xbean.TitleInfo _v_ : _o_.owntitle)
/*   64 */       this.owntitle.add(new TitleInfo(_v_, this, "owntitle"));
/*   65 */     this.activetitle = _o_.activetitle;
/*   66 */     this.activeappellation = _o_.activeappellation;
/*   67 */     this.pro2appellationid = _o_.pro2appellationid;
/*   68 */     this.appellations = new HashMap();
/*   69 */     for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : _o_.appellations.entrySet()) {
/*   70 */       this.appellations.put(_e_.getKey(), new AppellationInfo((xbean.AppellationInfo)_e_.getValue(), this, "appellations"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   75 */     this.owntitle = new ArrayList();
/*   76 */     for (xbean.TitleInfo _v_ : _o_.owntitle)
/*   77 */       this.owntitle.add(new TitleInfo(_v_, this, "owntitle"));
/*   78 */     this.activetitle = _o_.activetitle;
/*   79 */     this.activeappellation = _o_.activeappellation;
/*   80 */     this.pro2appellationid = _o_.pro2appellationid;
/*   81 */     this.appellations = new HashMap();
/*   82 */     for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : _o_.appellations.entrySet()) {
/*   83 */       this.appellations.put(_e_.getKey(), new AppellationInfo((xbean.AppellationInfo)_e_.getValue(), this, "appellations"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   89 */     _xdb_verify_unsafe_();
/*   90 */     _os_.compact_uint32(this.owntitle.size());
/*   91 */     for (xbean.TitleInfo _v_ : this.owntitle)
/*      */     {
/*   93 */       _v_.marshal(_os_);
/*      */     }
/*   95 */     _os_.marshal(this.activetitle);
/*   96 */     _os_.marshal(this.activeappellation);
/*   97 */     _os_.marshal(this.pro2appellationid);
/*   98 */     _os_.compact_uint32(this.appellations.size());
/*   99 */     for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : this.appellations.entrySet())
/*      */     {
/*  101 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  102 */       ((xbean.AppellationInfo)_e_.getValue()).marshal(_os_);
/*      */     }
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  113 */       xbean.TitleInfo _v_ = new TitleInfo(0, this, "owntitle");
/*  114 */       _v_.unmarshal(_os_);
/*  115 */       this.owntitle.add(_v_);
/*      */     }
/*  117 */     this.activetitle = _os_.unmarshal_int();
/*  118 */     this.activeappellation = _os_.unmarshal_int();
/*  119 */     this.pro2appellationid = _os_.unmarshal_int();
/*      */     
/*  121 */     int size = _os_.uncompact_uint32();
/*  122 */     if (size >= 12)
/*      */     {
/*  124 */       this.appellations = new HashMap(size * 2);
/*      */     }
/*  126 */     for (; size > 0; size--)
/*      */     {
/*  128 */       int _k_ = 0;
/*  129 */       _k_ = _os_.unmarshal_int();
/*  130 */       xbean.AppellationInfo _v_ = new AppellationInfo(0, this, "appellations");
/*  131 */       _v_.unmarshal(_os_);
/*  132 */       this.appellations.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  135 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  141 */     _xdb_verify_unsafe_();
/*  142 */     int _size_ = 0;
/*  143 */     for (xbean.TitleInfo _v_ : this.owntitle)
/*      */     {
/*  145 */       _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */     }
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(3, this.activetitle);
/*  148 */     _size_ += CodedOutputStream.computeInt32Size(4, this.activeappellation);
/*  149 */     _size_ += CodedOutputStream.computeInt32Size(5, this.pro2appellationid);
/*  150 */     for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : this.appellations.entrySet())
/*      */     {
/*  152 */       _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  153 */       _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */     }
/*  155 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  161 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  164 */       for (xbean.TitleInfo _v_ : this.owntitle)
/*      */       {
/*  166 */         _output_.writeMessage(1, _v_);
/*      */       }
/*  168 */       _output_.writeInt32(3, this.activetitle);
/*  169 */       _output_.writeInt32(4, this.activeappellation);
/*  170 */       _output_.writeInt32(5, this.pro2appellationid);
/*  171 */       for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : this.appellations.entrySet())
/*      */       {
/*  173 */         _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  174 */         _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  179 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  181 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  187 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  190 */       boolean done = false;
/*  191 */       while (!done)
/*      */       {
/*  193 */         int tag = _input_.readTag();
/*  194 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  198 */           done = true;
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  203 */           xbean.TitleInfo _v_ = new TitleInfo(0, this, "owntitle");
/*  204 */           _input_.readMessage(_v_);
/*  205 */           this.owntitle.add(_v_);
/*  206 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  210 */           this.activetitle = _input_.readInt32();
/*  211 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  215 */           this.activeappellation = _input_.readInt32();
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  220 */           this.pro2appellationid = _input_.readInt32();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  225 */           int _k_ = 0;
/*  226 */           _k_ = _input_.readInt32();
/*  227 */           int readTag = _input_.readTag();
/*  228 */           if (50 != readTag)
/*      */           {
/*  230 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  232 */           xbean.AppellationInfo _v_ = new AppellationInfo(0, this, "appellations");
/*  233 */           _input_.readMessage(_v_);
/*  234 */           this.appellations.put(Integer.valueOf(_k_), _v_);
/*  235 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  239 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  241 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  250 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  254 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  256 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TitleAppellation copy()
/*      */   {
/*  262 */     _xdb_verify_unsafe_();
/*  263 */     return new TitleAppellation(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TitleAppellation toData()
/*      */   {
/*  269 */     _xdb_verify_unsafe_();
/*  270 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TitleAppellation toBean()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return new TitleAppellation(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TitleAppellation toDataIf()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TitleAppellation toBeanIf()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<xbean.TitleInfo> getOwntitle()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return xdb.Logs.logList(new LogKey(this, "owntitle"), this.owntitle);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<xbean.TitleInfo> getOwntitleAsData()
/*      */   {
/*  310 */     _xdb_verify_unsafe_();
/*      */     
/*  312 */     TitleAppellation _o_ = this;
/*  313 */     List<xbean.TitleInfo> owntitle = new ArrayList();
/*  314 */     for (xbean.TitleInfo _v_ : _o_.owntitle)
/*  315 */       owntitle.add(new TitleInfo.Data(_v_));
/*  316 */     return owntitle;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActivetitle()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.activetitle;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActiveappellation()
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     return this.activeappellation;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPro2appellationid()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return this.pro2appellationid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.AppellationInfo> getAppellations()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return xdb.Logs.logMap(new LogKey(this, "appellations"), this.appellations);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.AppellationInfo> getAppellationsAsData()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*      */     
/*  357 */     TitleAppellation _o_ = this;
/*  358 */     Map<Integer, xbean.AppellationInfo> appellations = new HashMap();
/*  359 */     for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : _o_.appellations.entrySet())
/*  360 */       appellations.put(_e_.getKey(), new AppellationInfo.Data((xbean.AppellationInfo)_e_.getValue()));
/*  361 */     return appellations;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActivetitle(int _v_)
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     xdb.Logs.logIf(new LogKey(this, "activetitle")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  373 */         new xdb.logs.LogInt(this, TitleAppellation.this.activetitle)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  377 */             TitleAppellation.this.activetitle = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  381 */     });
/*  382 */     this.activetitle = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActiveappellation(int _v_)
/*      */   {
/*  389 */     _xdb_verify_unsafe_();
/*  390 */     xdb.Logs.logIf(new LogKey(this, "activeappellation")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  394 */         new xdb.logs.LogInt(this, TitleAppellation.this.activeappellation)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  398 */             TitleAppellation.this.activeappellation = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  402 */     });
/*  403 */     this.activeappellation = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPro2appellationid(int _v_)
/*      */   {
/*  410 */     _xdb_verify_unsafe_();
/*  411 */     xdb.Logs.logIf(new LogKey(this, "pro2appellationid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  415 */         new xdb.logs.LogInt(this, TitleAppellation.this.pro2appellationid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  419 */             TitleAppellation.this.pro2appellationid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  423 */     });
/*  424 */     this.pro2appellationid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     TitleAppellation _o_ = null;
/*  432 */     if ((_o1_ instanceof TitleAppellation)) { _o_ = (TitleAppellation)_o1_;
/*  433 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  434 */       return false;
/*  435 */     if (!this.owntitle.equals(_o_.owntitle)) return false;
/*  436 */     if (this.activetitle != _o_.activetitle) return false;
/*  437 */     if (this.activeappellation != _o_.activeappellation) return false;
/*  438 */     if (this.pro2appellationid != _o_.pro2appellationid) return false;
/*  439 */     if (!this.appellations.equals(_o_.appellations)) return false;
/*  440 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  446 */     _xdb_verify_unsafe_();
/*  447 */     int _h_ = 0;
/*  448 */     _h_ += this.owntitle.hashCode();
/*  449 */     _h_ += this.activetitle;
/*  450 */     _h_ += this.activeappellation;
/*  451 */     _h_ += this.pro2appellationid;
/*  452 */     _h_ += this.appellations.hashCode();
/*  453 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  459 */     _xdb_verify_unsafe_();
/*  460 */     StringBuilder _sb_ = new StringBuilder();
/*  461 */     _sb_.append("(");
/*  462 */     _sb_.append(this.owntitle);
/*  463 */     _sb_.append(",");
/*  464 */     _sb_.append(this.activetitle);
/*  465 */     _sb_.append(",");
/*  466 */     _sb_.append(this.activeappellation);
/*  467 */     _sb_.append(",");
/*  468 */     _sb_.append(this.pro2appellationid);
/*  469 */     _sb_.append(",");
/*  470 */     _sb_.append(this.appellations);
/*  471 */     _sb_.append(")");
/*  472 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  478 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  479 */     lb.add(new xdb.logs.ListenableChanged().setVarName("owntitle"));
/*  480 */     lb.add(new xdb.logs.ListenableChanged().setVarName("activetitle"));
/*  481 */     lb.add(new xdb.logs.ListenableChanged().setVarName("activeappellation"));
/*  482 */     lb.add(new xdb.logs.ListenableChanged().setVarName("pro2appellationid"));
/*  483 */     lb.add(new xdb.logs.ListenableMap().setVarName("appellations"));
/*  484 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.TitleAppellation {
/*      */     private Const() {}
/*      */     
/*      */     TitleAppellation nThis() {
/*  491 */       return TitleAppellation.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  497 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TitleAppellation copy()
/*      */     {
/*  503 */       return TitleAppellation.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TitleAppellation toData()
/*      */     {
/*  509 */       return TitleAppellation.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.TitleAppellation toBean()
/*      */     {
/*  514 */       return TitleAppellation.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TitleAppellation toDataIf()
/*      */     {
/*  520 */       return TitleAppellation.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.TitleAppellation toBeanIf()
/*      */     {
/*  525 */       return TitleAppellation.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.TitleInfo> getOwntitle()
/*      */     {
/*  532 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  533 */       return xdb.Consts.constList(TitleAppellation.this.owntitle);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<xbean.TitleInfo> getOwntitleAsData()
/*      */     {
/*  539 */       TitleAppellation.this._xdb_verify_unsafe_();
/*      */       
/*  541 */       TitleAppellation _o_ = TitleAppellation.this;
/*  542 */       List<xbean.TitleInfo> owntitle = new ArrayList();
/*  543 */       for (xbean.TitleInfo _v_ : _o_.owntitle)
/*  544 */         owntitle.add(new TitleInfo.Data(_v_));
/*  545 */       return owntitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivetitle()
/*      */     {
/*  552 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  553 */       return TitleAppellation.this.activetitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActiveappellation()
/*      */     {
/*  560 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  561 */       return TitleAppellation.this.activeappellation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPro2appellationid()
/*      */     {
/*  568 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  569 */       return TitleAppellation.this.pro2appellationid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AppellationInfo> getAppellations()
/*      */     {
/*  576 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  577 */       return xdb.Consts.constMap(TitleAppellation.this.appellations);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AppellationInfo> getAppellationsAsData()
/*      */     {
/*  584 */       TitleAppellation.this._xdb_verify_unsafe_();
/*      */       
/*  586 */       TitleAppellation _o_ = TitleAppellation.this;
/*  587 */       Map<Integer, xbean.AppellationInfo> appellations = new HashMap();
/*  588 */       for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : _o_.appellations.entrySet())
/*  589 */         appellations.put(_e_.getKey(), new AppellationInfo.Data((xbean.AppellationInfo)_e_.getValue()));
/*  590 */       return appellations;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivetitle(int _v_)
/*      */     {
/*  597 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  598 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActiveappellation(int _v_)
/*      */     {
/*  605 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  606 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPro2appellationid(int _v_)
/*      */     {
/*  613 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  614 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  620 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  621 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  627 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  628 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  634 */       return TitleAppellation.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  640 */       return TitleAppellation.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  646 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  647 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  653 */       return TitleAppellation.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  659 */       return TitleAppellation.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  665 */       TitleAppellation.this._xdb_verify_unsafe_();
/*  666 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  672 */       return TitleAppellation.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  678 */       return TitleAppellation.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  684 */       return TitleAppellation.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  690 */       return TitleAppellation.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  696 */       return TitleAppellation.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  702 */       return TitleAppellation.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  708 */       return TitleAppellation.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.TitleAppellation
/*      */   {
/*      */     private ArrayList<xbean.TitleInfo> owntitle;
/*      */     
/*      */     private int activetitle;
/*      */     
/*      */     private int activeappellation;
/*      */     
/*      */     private int pro2appellationid;
/*      */     
/*      */     private HashMap<Integer, xbean.AppellationInfo> appellations;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  728 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  733 */       this.owntitle = new ArrayList();
/*  734 */       this.appellations = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.TitleAppellation _o1_)
/*      */     {
/*  739 */       if ((_o1_ instanceof TitleAppellation)) { assign((TitleAppellation)_o1_);
/*  740 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  741 */       } else if ((_o1_ instanceof TitleAppellation.Const)) assign(((TitleAppellation.Const)_o1_).nThis()); else {
/*  742 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(TitleAppellation _o_) {
/*  747 */       this.owntitle = new ArrayList();
/*  748 */       for (xbean.TitleInfo _v_ : _o_.owntitle)
/*  749 */         this.owntitle.add(new TitleInfo.Data(_v_));
/*  750 */       this.activetitle = _o_.activetitle;
/*  751 */       this.activeappellation = _o_.activeappellation;
/*  752 */       this.pro2appellationid = _o_.pro2appellationid;
/*  753 */       this.appellations = new HashMap();
/*  754 */       for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : _o_.appellations.entrySet()) {
/*  755 */         this.appellations.put(_e_.getKey(), new AppellationInfo.Data((xbean.AppellationInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  760 */       this.owntitle = new ArrayList();
/*  761 */       for (xbean.TitleInfo _v_ : _o_.owntitle)
/*  762 */         this.owntitle.add(new TitleInfo.Data(_v_));
/*  763 */       this.activetitle = _o_.activetitle;
/*  764 */       this.activeappellation = _o_.activeappellation;
/*  765 */       this.pro2appellationid = _o_.pro2appellationid;
/*  766 */       this.appellations = new HashMap();
/*  767 */       for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : _o_.appellations.entrySet()) {
/*  768 */         this.appellations.put(_e_.getKey(), new AppellationInfo.Data((xbean.AppellationInfo)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  774 */       _os_.compact_uint32(this.owntitle.size());
/*  775 */       for (xbean.TitleInfo _v_ : this.owntitle)
/*      */       {
/*  777 */         _v_.marshal(_os_);
/*      */       }
/*  779 */       _os_.marshal(this.activetitle);
/*  780 */       _os_.marshal(this.activeappellation);
/*  781 */       _os_.marshal(this.pro2appellationid);
/*  782 */       _os_.compact_uint32(this.appellations.size());
/*  783 */       for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : this.appellations.entrySet())
/*      */       {
/*  785 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  786 */         ((xbean.AppellationInfo)_e_.getValue()).marshal(_os_);
/*      */       }
/*  788 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  794 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  796 */         xbean.TitleInfo _v_ = xbean.Pod.newTitleInfoData();
/*  797 */         _v_.unmarshal(_os_);
/*  798 */         this.owntitle.add(_v_);
/*      */       }
/*  800 */       this.activetitle = _os_.unmarshal_int();
/*  801 */       this.activeappellation = _os_.unmarshal_int();
/*  802 */       this.pro2appellationid = _os_.unmarshal_int();
/*      */       
/*  804 */       int size = _os_.uncompact_uint32();
/*  805 */       if (size >= 12)
/*      */       {
/*  807 */         this.appellations = new HashMap(size * 2);
/*      */       }
/*  809 */       for (; size > 0; size--)
/*      */       {
/*  811 */         int _k_ = 0;
/*  812 */         _k_ = _os_.unmarshal_int();
/*  813 */         xbean.AppellationInfo _v_ = xbean.Pod.newAppellationInfoData();
/*  814 */         _v_.unmarshal(_os_);
/*  815 */         this.appellations.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  818 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  824 */       int _size_ = 0;
/*  825 */       for (xbean.TitleInfo _v_ : this.owntitle)
/*      */       {
/*  827 */         _size_ += CodedOutputStream.computeMessageSize(1, _v_);
/*      */       }
/*  829 */       _size_ += CodedOutputStream.computeInt32Size(3, this.activetitle);
/*  830 */       _size_ += CodedOutputStream.computeInt32Size(4, this.activeappellation);
/*  831 */       _size_ += CodedOutputStream.computeInt32Size(5, this.pro2appellationid);
/*  832 */       for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : this.appellations.entrySet())
/*      */       {
/*  834 */         _size_ += CodedOutputStream.computeInt32Size(6, ((Integer)_e_.getKey()).intValue());
/*  835 */         _size_ += CodedOutputStream.computeMessageSize(6, (ppbio.Message)_e_.getValue());
/*      */       }
/*  837 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  845 */         for (xbean.TitleInfo _v_ : this.owntitle)
/*      */         {
/*  847 */           _output_.writeMessage(1, _v_);
/*      */         }
/*  849 */         _output_.writeInt32(3, this.activetitle);
/*  850 */         _output_.writeInt32(4, this.activeappellation);
/*  851 */         _output_.writeInt32(5, this.pro2appellationid);
/*  852 */         for (Map.Entry<Integer, xbean.AppellationInfo> _e_ : this.appellations.entrySet())
/*      */         {
/*  854 */           _output_.writeInt32(6, ((Integer)_e_.getKey()).intValue());
/*  855 */           _output_.writeMessage(6, (ppbio.Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  860 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  862 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  870 */         boolean done = false;
/*  871 */         while (!done)
/*      */         {
/*  873 */           int tag = _input_.readTag();
/*  874 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  878 */             done = true;
/*  879 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/*  883 */             xbean.TitleInfo _v_ = xbean.Pod.newTitleInfoData();
/*  884 */             _input_.readMessage(_v_);
/*  885 */             this.owntitle.add(_v_);
/*  886 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  890 */             this.activetitle = _input_.readInt32();
/*  891 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  895 */             this.activeappellation = _input_.readInt32();
/*  896 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  900 */             this.pro2appellationid = _input_.readInt32();
/*  901 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  905 */             int _k_ = 0;
/*  906 */             _k_ = _input_.readInt32();
/*  907 */             int readTag = _input_.readTag();
/*  908 */             if (50 != readTag)
/*      */             {
/*  910 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  912 */             xbean.AppellationInfo _v_ = xbean.Pod.newAppellationInfoData();
/*  913 */             _input_.readMessage(_v_);
/*  914 */             this.appellations.put(Integer.valueOf(_k_), _v_);
/*  915 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  919 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  921 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  930 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  934 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  936 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TitleAppellation copy()
/*      */     {
/*  942 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TitleAppellation toData()
/*      */     {
/*  948 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.TitleAppellation toBean()
/*      */     {
/*  953 */       return new TitleAppellation(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TitleAppellation toDataIf()
/*      */     {
/*  959 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.TitleAppellation toBeanIf()
/*      */     {
/*  964 */       return new TitleAppellation(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  970 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  974 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  978 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  982 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  986 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  990 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  994 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.TitleInfo> getOwntitle()
/*      */     {
/* 1001 */       return this.owntitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<xbean.TitleInfo> getOwntitleAsData()
/*      */     {
/* 1008 */       return this.owntitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActivetitle()
/*      */     {
/* 1015 */       return this.activetitle;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActiveappellation()
/*      */     {
/* 1022 */       return this.activeappellation;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPro2appellationid()
/*      */     {
/* 1029 */       return this.pro2appellationid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AppellationInfo> getAppellations()
/*      */     {
/* 1036 */       return this.appellations;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.AppellationInfo> getAppellationsAsData()
/*      */     {
/* 1043 */       return this.appellations;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActivetitle(int _v_)
/*      */     {
/* 1050 */       this.activetitle = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActiveappellation(int _v_)
/*      */     {
/* 1057 */       this.activeappellation = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPro2appellationid(int _v_)
/*      */     {
/* 1064 */       this.pro2appellationid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1070 */       if (!(_o1_ instanceof Data)) return false;
/* 1071 */       Data _o_ = (Data)_o1_;
/* 1072 */       if (!this.owntitle.equals(_o_.owntitle)) return false;
/* 1073 */       if (this.activetitle != _o_.activetitle) return false;
/* 1074 */       if (this.activeappellation != _o_.activeappellation) return false;
/* 1075 */       if (this.pro2appellationid != _o_.pro2appellationid) return false;
/* 1076 */       if (!this.appellations.equals(_o_.appellations)) return false;
/* 1077 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1083 */       int _h_ = 0;
/* 1084 */       _h_ += this.owntitle.hashCode();
/* 1085 */       _h_ += this.activetitle;
/* 1086 */       _h_ += this.activeappellation;
/* 1087 */       _h_ += this.pro2appellationid;
/* 1088 */       _h_ += this.appellations.hashCode();
/* 1089 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1095 */       StringBuilder _sb_ = new StringBuilder();
/* 1096 */       _sb_.append("(");
/* 1097 */       _sb_.append(this.owntitle);
/* 1098 */       _sb_.append(",");
/* 1099 */       _sb_.append(this.activetitle);
/* 1100 */       _sb_.append(",");
/* 1101 */       _sb_.append(this.activeappellation);
/* 1102 */       _sb_.append(",");
/* 1103 */       _sb_.append(this.pro2appellationid);
/* 1104 */       _sb_.append(",");
/* 1105 */       _sb_.append(this.appellations);
/* 1106 */       _sb_.append(")");
/* 1107 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TitleAppellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */