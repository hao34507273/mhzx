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
/*      */ import xdb.XBean;
/*      */ 
/*      */ public final class PartnerBag extends XBean implements xbean.PartnerBag
/*      */ {
/*      */   private int defaultlineupnum;
/*      */   private ArrayList<Integer> ownpartnerids;
/*      */   private HashMap<Integer, xbean.LineUp> lineups;
/*      */   private HashMap<Integer, xbean.Property> partner2property;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.defaultlineupnum = 0;
/*   25 */     this.ownpartnerids.clear();
/*   26 */     this.lineups.clear();
/*   27 */     this.partner2property.clear();
/*      */   }
/*      */   
/*      */   PartnerBag(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.ownpartnerids = new ArrayList();
/*   34 */     this.lineups = new HashMap();
/*   35 */     this.partner2property = new HashMap();
/*      */   }
/*      */   
/*      */   public PartnerBag()
/*      */   {
/*   40 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public PartnerBag(PartnerBag _o_)
/*      */   {
/*   45 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   PartnerBag(xbean.PartnerBag _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     if ((_o1_ instanceof PartnerBag)) { assign((PartnerBag)_o1_);
/*   52 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   53 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   54 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(PartnerBag _o_) {
/*   59 */     _o_._xdb_verify_unsafe_();
/*   60 */     this.defaultlineupnum = _o_.defaultlineupnum;
/*   61 */     this.ownpartnerids = new ArrayList();
/*   62 */     this.ownpartnerids.addAll(_o_.ownpartnerids);
/*   63 */     this.lineups = new HashMap();
/*   64 */     for (Map.Entry<Integer, xbean.LineUp> _e_ : _o_.lineups.entrySet())
/*   65 */       this.lineups.put(_e_.getKey(), new LineUp((xbean.LineUp)_e_.getValue(), this, "lineups"));
/*   66 */     this.partner2property = new HashMap();
/*   67 */     for (Map.Entry<Integer, xbean.Property> _e_ : _o_.partner2property.entrySet()) {
/*   68 */       this.partner2property.put(_e_.getKey(), new Property((xbean.Property)_e_.getValue(), this, "partner2property"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   73 */     this.defaultlineupnum = _o_.defaultlineupnum;
/*   74 */     this.ownpartnerids = new ArrayList();
/*   75 */     this.ownpartnerids.addAll(_o_.ownpartnerids);
/*   76 */     this.lineups = new HashMap();
/*   77 */     for (Map.Entry<Integer, xbean.LineUp> _e_ : _o_.lineups.entrySet())
/*   78 */       this.lineups.put(_e_.getKey(), new LineUp((xbean.LineUp)_e_.getValue(), this, "lineups"));
/*   79 */     this.partner2property = new HashMap();
/*   80 */     for (Map.Entry<Integer, xbean.Property> _e_ : _o_.partner2property.entrySet()) {
/*   81 */       this.partner2property.put(_e_.getKey(), new Property((xbean.Property)_e_.getValue(), this, "partner2property"));
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   87 */     _xdb_verify_unsafe_();
/*   88 */     _os_.marshal(this.defaultlineupnum);
/*   89 */     _os_.compact_uint32(this.ownpartnerids.size());
/*   90 */     for (Integer _v_ : this.ownpartnerids)
/*      */     {
/*   92 */       _os_.marshal(_v_.intValue());
/*      */     }
/*   94 */     _os_.compact_uint32(this.lineups.size());
/*   95 */     for (Map.Entry<Integer, xbean.LineUp> _e_ : this.lineups.entrySet())
/*      */     {
/*   97 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   98 */       ((xbean.LineUp)_e_.getValue()).marshal(_os_);
/*      */     }
/*  100 */     _os_.compact_uint32(this.partner2property.size());
/*  101 */     for (Map.Entry<Integer, xbean.Property> _e_ : this.partner2property.entrySet())
/*      */     {
/*  103 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  104 */       ((xbean.Property)_e_.getValue()).marshal(_os_);
/*      */     }
/*  106 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  112 */     _xdb_verify_unsafe_();
/*  113 */     this.defaultlineupnum = _os_.unmarshal_int();
/*  114 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  116 */       int _v_ = 0;
/*  117 */       _v_ = _os_.unmarshal_int();
/*  118 */       this.ownpartnerids.add(Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  121 */     int size = _os_.uncompact_uint32();
/*  122 */     if (size >= 12)
/*      */     {
/*  124 */       this.lineups = new HashMap(size * 2);
/*      */     }
/*  126 */     for (; size > 0; size--)
/*      */     {
/*  128 */       int _k_ = 0;
/*  129 */       _k_ = _os_.unmarshal_int();
/*  130 */       xbean.LineUp _v_ = new LineUp(0, this, "lineups");
/*  131 */       _v_.unmarshal(_os_);
/*  132 */       this.lineups.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*      */ 
/*  136 */     int size = _os_.uncompact_uint32();
/*  137 */     if (size >= 12)
/*      */     {
/*  139 */       this.partner2property = new HashMap(size * 2);
/*      */     }
/*  141 */     for (; size > 0; size--)
/*      */     {
/*  143 */       int _k_ = 0;
/*  144 */       _k_ = _os_.unmarshal_int();
/*  145 */       xbean.Property _v_ = new Property(0, this, "partner2property");
/*  146 */       _v_.unmarshal(_os_);
/*  147 */       this.partner2property.put(Integer.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  150 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  156 */     _xdb_verify_unsafe_();
/*  157 */     int _size_ = 0;
/*  158 */     _size_ += CodedOutputStream.computeInt32Size(1, this.defaultlineupnum);
/*  159 */     for (Integer _v_ : this.ownpartnerids)
/*      */     {
/*  161 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */     }
/*  163 */     for (Map.Entry<Integer, xbean.LineUp> _e_ : this.lineups.entrySet())
/*      */     {
/*  165 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  166 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */     }
/*  168 */     for (Map.Entry<Integer, xbean.Property> _e_ : this.partner2property.entrySet())
/*      */     {
/*  170 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  171 */       _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */     }
/*  173 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  179 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  182 */       _output_.writeInt32(1, this.defaultlineupnum);
/*  183 */       for (Integer _v_ : this.ownpartnerids)
/*      */       {
/*  185 */         _output_.writeInt32(2, _v_.intValue());
/*      */       }
/*  187 */       for (Map.Entry<Integer, xbean.LineUp> _e_ : this.lineups.entrySet())
/*      */       {
/*  189 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  190 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  192 */       for (Map.Entry<Integer, xbean.Property> _e_ : this.partner2property.entrySet())
/*      */       {
/*  194 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  195 */         _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  200 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  202 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  208 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  211 */       boolean done = false;
/*  212 */       while (!done)
/*      */       {
/*  214 */         int tag = _input_.readTag();
/*  215 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  219 */           done = true;
/*  220 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  224 */           this.defaultlineupnum = _input_.readInt32();
/*  225 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  229 */           int _v_ = 0;
/*  230 */           _v_ = _input_.readInt32();
/*  231 */           this.ownpartnerids.add(Integer.valueOf(_v_));
/*  232 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  236 */           int _k_ = 0;
/*  237 */           _k_ = _input_.readInt32();
/*  238 */           int readTag = _input_.readTag();
/*  239 */           if (26 != readTag)
/*      */           {
/*  241 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  243 */           xbean.LineUp _v_ = new LineUp(0, this, "lineups");
/*  244 */           _input_.readMessage(_v_);
/*  245 */           this.lineups.put(Integer.valueOf(_k_), _v_);
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  250 */           int _k_ = 0;
/*  251 */           _k_ = _input_.readInt32();
/*  252 */           int readTag = _input_.readTag();
/*  253 */           if (34 != readTag)
/*      */           {
/*  255 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  257 */           xbean.Property _v_ = new Property(0, this, "partner2property");
/*  258 */           _input_.readMessage(_v_);
/*  259 */           this.partner2property.put(Integer.valueOf(_k_), _v_);
/*  260 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  264 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  266 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  275 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  279 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  281 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PartnerBag copy()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new PartnerBag(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PartnerBag toData()
/*      */   {
/*  294 */     _xdb_verify_unsafe_();
/*  295 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PartnerBag toBean()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new PartnerBag(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.PartnerBag toDataIf()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.PartnerBag toBeanIf()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDefaultlineupnum()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return this.defaultlineupnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Integer> getOwnpartnerids()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return xdb.Logs.logList(new xdb.LogKey(this, "ownpartnerids"), this.ownpartnerids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Integer> getOwnpartneridsAsData()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*      */     
/*  345 */     PartnerBag _o_ = this;
/*  346 */     List<Integer> ownpartnerids = new ArrayList();
/*  347 */     ownpartnerids.addAll(_o_.ownpartnerids);
/*  348 */     return ownpartnerids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.LineUp> getLineups()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return xdb.Logs.logMap(new xdb.LogKey(this, "lineups"), this.lineups);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.LineUp> getLineupsAsData()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*      */     
/*  365 */     PartnerBag _o_ = this;
/*  366 */     Map<Integer, xbean.LineUp> lineups = new HashMap();
/*  367 */     for (Map.Entry<Integer, xbean.LineUp> _e_ : _o_.lineups.entrySet())
/*  368 */       lineups.put(_e_.getKey(), new LineUp.Data((xbean.LineUp)_e_.getValue()));
/*  369 */     return lineups;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Property> getPartner2property()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return xdb.Logs.logMap(new xdb.LogKey(this, "partner2property"), this.partner2property);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, xbean.Property> getPartner2propertyAsData()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*      */     
/*  386 */     PartnerBag _o_ = this;
/*  387 */     Map<Integer, xbean.Property> partner2property = new HashMap();
/*  388 */     for (Map.Entry<Integer, xbean.Property> _e_ : _o_.partner2property.entrySet())
/*  389 */       partner2property.put(_e_.getKey(), new Property.Data((xbean.Property)_e_.getValue()));
/*  390 */     return partner2property;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDefaultlineupnum(int _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     xdb.Logs.logIf(new xdb.LogKey(this, "defaultlineupnum")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  402 */         new xdb.logs.LogInt(this, PartnerBag.this.defaultlineupnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             PartnerBag.this.defaultlineupnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.defaultlineupnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     PartnerBag _o_ = null;
/*  419 */     if ((_o1_ instanceof PartnerBag)) { _o_ = (PartnerBag)_o1_;
/*  420 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  421 */       return false;
/*  422 */     if (this.defaultlineupnum != _o_.defaultlineupnum) return false;
/*  423 */     if (!this.ownpartnerids.equals(_o_.ownpartnerids)) return false;
/*  424 */     if (!this.lineups.equals(_o_.lineups)) return false;
/*  425 */     if (!this.partner2property.equals(_o_.partner2property)) return false;
/*  426 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     int _h_ = 0;
/*  434 */     _h_ += this.defaultlineupnum;
/*  435 */     _h_ += this.ownpartnerids.hashCode();
/*  436 */     _h_ += this.lineups.hashCode();
/*  437 */     _h_ += this.partner2property.hashCode();
/*  438 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  444 */     _xdb_verify_unsafe_();
/*  445 */     StringBuilder _sb_ = new StringBuilder();
/*  446 */     _sb_.append("(");
/*  447 */     _sb_.append(this.defaultlineupnum);
/*  448 */     _sb_.append(",");
/*  449 */     _sb_.append(this.ownpartnerids);
/*  450 */     _sb_.append(",");
/*  451 */     _sb_.append(this.lineups);
/*  452 */     _sb_.append(",");
/*  453 */     _sb_.append(this.partner2property);
/*  454 */     _sb_.append(")");
/*  455 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  461 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  462 */     lb.add(new xdb.logs.ListenableChanged().setVarName("defaultlineupnum"));
/*  463 */     lb.add(new xdb.logs.ListenableChanged().setVarName("ownpartnerids"));
/*  464 */     lb.add(new xdb.logs.ListenableMap().setVarName("lineups"));
/*  465 */     lb.add(new xdb.logs.ListenableMap().setVarName("partner2property"));
/*  466 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.PartnerBag {
/*      */     private Const() {}
/*      */     
/*      */     PartnerBag nThis() {
/*  473 */       return PartnerBag.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  479 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PartnerBag copy()
/*      */     {
/*  485 */       return PartnerBag.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PartnerBag toData()
/*      */     {
/*  491 */       return PartnerBag.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.PartnerBag toBean()
/*      */     {
/*  496 */       return PartnerBag.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PartnerBag toDataIf()
/*      */     {
/*  502 */       return PartnerBag.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.PartnerBag toBeanIf()
/*      */     {
/*  507 */       return PartnerBag.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefaultlineupnum()
/*      */     {
/*  514 */       PartnerBag.this._xdb_verify_unsafe_();
/*  515 */       return PartnerBag.this.defaultlineupnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOwnpartnerids()
/*      */     {
/*  522 */       PartnerBag.this._xdb_verify_unsafe_();
/*  523 */       return xdb.Consts.constList(PartnerBag.this.ownpartnerids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Integer> getOwnpartneridsAsData()
/*      */     {
/*  529 */       PartnerBag.this._xdb_verify_unsafe_();
/*      */       
/*  531 */       PartnerBag _o_ = PartnerBag.this;
/*  532 */       List<Integer> ownpartnerids = new ArrayList();
/*  533 */       ownpartnerids.addAll(_o_.ownpartnerids);
/*  534 */       return ownpartnerids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LineUp> getLineups()
/*      */     {
/*  541 */       PartnerBag.this._xdb_verify_unsafe_();
/*  542 */       return xdb.Consts.constMap(PartnerBag.this.lineups);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LineUp> getLineupsAsData()
/*      */     {
/*  549 */       PartnerBag.this._xdb_verify_unsafe_();
/*      */       
/*  551 */       PartnerBag _o_ = PartnerBag.this;
/*  552 */       Map<Integer, xbean.LineUp> lineups = new HashMap();
/*  553 */       for (Map.Entry<Integer, xbean.LineUp> _e_ : _o_.lineups.entrySet())
/*  554 */         lineups.put(_e_.getKey(), new LineUp.Data((xbean.LineUp)_e_.getValue()));
/*  555 */       return lineups;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Property> getPartner2property()
/*      */     {
/*  562 */       PartnerBag.this._xdb_verify_unsafe_();
/*  563 */       return xdb.Consts.constMap(PartnerBag.this.partner2property);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Property> getPartner2propertyAsData()
/*      */     {
/*  570 */       PartnerBag.this._xdb_verify_unsafe_();
/*      */       
/*  572 */       PartnerBag _o_ = PartnerBag.this;
/*  573 */       Map<Integer, xbean.Property> partner2property = new HashMap();
/*  574 */       for (Map.Entry<Integer, xbean.Property> _e_ : _o_.partner2property.entrySet())
/*  575 */         partner2property.put(_e_.getKey(), new Property.Data((xbean.Property)_e_.getValue()));
/*  576 */       return partner2property;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefaultlineupnum(int _v_)
/*      */     {
/*  583 */       PartnerBag.this._xdb_verify_unsafe_();
/*  584 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  590 */       PartnerBag.this._xdb_verify_unsafe_();
/*  591 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  597 */       PartnerBag.this._xdb_verify_unsafe_();
/*  598 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  604 */       return PartnerBag.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  610 */       return PartnerBag.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  616 */       PartnerBag.this._xdb_verify_unsafe_();
/*  617 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  623 */       return PartnerBag.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  629 */       return PartnerBag.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  635 */       PartnerBag.this._xdb_verify_unsafe_();
/*  636 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  642 */       return PartnerBag.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  648 */       return PartnerBag.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  654 */       return PartnerBag.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  660 */       return PartnerBag.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  666 */       return PartnerBag.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  672 */       return PartnerBag.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  678 */       return PartnerBag.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.PartnerBag
/*      */   {
/*      */     private int defaultlineupnum;
/*      */     
/*      */     private ArrayList<Integer> ownpartnerids;
/*      */     
/*      */     private HashMap<Integer, xbean.LineUp> lineups;
/*      */     
/*      */     private HashMap<Integer, xbean.Property> partner2property;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  696 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  701 */       this.ownpartnerids = new ArrayList();
/*  702 */       this.lineups = new HashMap();
/*  703 */       this.partner2property = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.PartnerBag _o1_)
/*      */     {
/*  708 */       if ((_o1_ instanceof PartnerBag)) { assign((PartnerBag)_o1_);
/*  709 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  710 */       } else if ((_o1_ instanceof PartnerBag.Const)) assign(((PartnerBag.Const)_o1_).nThis()); else {
/*  711 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(PartnerBag _o_) {
/*  716 */       this.defaultlineupnum = _o_.defaultlineupnum;
/*  717 */       this.ownpartnerids = new ArrayList();
/*  718 */       this.ownpartnerids.addAll(_o_.ownpartnerids);
/*  719 */       this.lineups = new HashMap();
/*  720 */       for (Map.Entry<Integer, xbean.LineUp> _e_ : _o_.lineups.entrySet())
/*  721 */         this.lineups.put(_e_.getKey(), new LineUp.Data((xbean.LineUp)_e_.getValue()));
/*  722 */       this.partner2property = new HashMap();
/*  723 */       for (Map.Entry<Integer, xbean.Property> _e_ : _o_.partner2property.entrySet()) {
/*  724 */         this.partner2property.put(_e_.getKey(), new Property.Data((xbean.Property)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  729 */       this.defaultlineupnum = _o_.defaultlineupnum;
/*  730 */       this.ownpartnerids = new ArrayList();
/*  731 */       this.ownpartnerids.addAll(_o_.ownpartnerids);
/*  732 */       this.lineups = new HashMap();
/*  733 */       for (Map.Entry<Integer, xbean.LineUp> _e_ : _o_.lineups.entrySet())
/*  734 */         this.lineups.put(_e_.getKey(), new LineUp.Data((xbean.LineUp)_e_.getValue()));
/*  735 */       this.partner2property = new HashMap();
/*  736 */       for (Map.Entry<Integer, xbean.Property> _e_ : _o_.partner2property.entrySet()) {
/*  737 */         this.partner2property.put(_e_.getKey(), new Property.Data((xbean.Property)_e_.getValue()));
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  743 */       _os_.marshal(this.defaultlineupnum);
/*  744 */       _os_.compact_uint32(this.ownpartnerids.size());
/*  745 */       for (Integer _v_ : this.ownpartnerids)
/*      */       {
/*  747 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  749 */       _os_.compact_uint32(this.lineups.size());
/*  750 */       for (Map.Entry<Integer, xbean.LineUp> _e_ : this.lineups.entrySet())
/*      */       {
/*  752 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  753 */         ((xbean.LineUp)_e_.getValue()).marshal(_os_);
/*      */       }
/*  755 */       _os_.compact_uint32(this.partner2property.size());
/*  756 */       for (Map.Entry<Integer, xbean.Property> _e_ : this.partner2property.entrySet())
/*      */       {
/*  758 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  759 */         ((xbean.Property)_e_.getValue()).marshal(_os_);
/*      */       }
/*  761 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  767 */       this.defaultlineupnum = _os_.unmarshal_int();
/*  768 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  770 */         int _v_ = 0;
/*  771 */         _v_ = _os_.unmarshal_int();
/*  772 */         this.ownpartnerids.add(Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  775 */       int size = _os_.uncompact_uint32();
/*  776 */       if (size >= 12)
/*      */       {
/*  778 */         this.lineups = new HashMap(size * 2);
/*      */       }
/*  780 */       for (; size > 0; size--)
/*      */       {
/*  782 */         int _k_ = 0;
/*  783 */         _k_ = _os_.unmarshal_int();
/*  784 */         xbean.LineUp _v_ = xbean.Pod.newLineUpData();
/*  785 */         _v_.unmarshal(_os_);
/*  786 */         this.lineups.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*      */ 
/*  790 */       int size = _os_.uncompact_uint32();
/*  791 */       if (size >= 12)
/*      */       {
/*  793 */         this.partner2property = new HashMap(size * 2);
/*      */       }
/*  795 */       for (; size > 0; size--)
/*      */       {
/*  797 */         int _k_ = 0;
/*  798 */         _k_ = _os_.unmarshal_int();
/*  799 */         xbean.Property _v_ = xbean.Pod.newPropertyData();
/*  800 */         _v_.unmarshal(_os_);
/*  801 */         this.partner2property.put(Integer.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  804 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  810 */       int _size_ = 0;
/*  811 */       _size_ += CodedOutputStream.computeInt32Size(1, this.defaultlineupnum);
/*  812 */       for (Integer _v_ : this.ownpartnerids)
/*      */       {
/*  814 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*      */       }
/*  816 */       for (Map.Entry<Integer, xbean.LineUp> _e_ : this.lineups.entrySet())
/*      */       {
/*  818 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/*  819 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*      */       }
/*  821 */       for (Map.Entry<Integer, xbean.Property> _e_ : this.partner2property.entrySet())
/*      */       {
/*  823 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  824 */         _size_ += CodedOutputStream.computeMessageSize(4, (ppbio.Message)_e_.getValue());
/*      */       }
/*  826 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  834 */         _output_.writeInt32(1, this.defaultlineupnum);
/*  835 */         for (Integer _v_ : this.ownpartnerids)
/*      */         {
/*  837 */           _output_.writeInt32(2, _v_.intValue());
/*      */         }
/*  839 */         for (Map.Entry<Integer, xbean.LineUp> _e_ : this.lineups.entrySet())
/*      */         {
/*  841 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/*  842 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*      */         }
/*  844 */         for (Map.Entry<Integer, xbean.Property> _e_ : this.partner2property.entrySet())
/*      */         {
/*  846 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  847 */           _output_.writeMessage(4, (ppbio.Message)_e_.getValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  852 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  854 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  862 */         boolean done = false;
/*  863 */         while (!done)
/*      */         {
/*  865 */           int tag = _input_.readTag();
/*  866 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  870 */             done = true;
/*  871 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  875 */             this.defaultlineupnum = _input_.readInt32();
/*  876 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  880 */             int _v_ = 0;
/*  881 */             _v_ = _input_.readInt32();
/*  882 */             this.ownpartnerids.add(Integer.valueOf(_v_));
/*  883 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  887 */             int _k_ = 0;
/*  888 */             _k_ = _input_.readInt32();
/*  889 */             int readTag = _input_.readTag();
/*  890 */             if (26 != readTag)
/*      */             {
/*  892 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  894 */             xbean.LineUp _v_ = xbean.Pod.newLineUpData();
/*  895 */             _input_.readMessage(_v_);
/*  896 */             this.lineups.put(Integer.valueOf(_k_), _v_);
/*  897 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  901 */             int _k_ = 0;
/*  902 */             _k_ = _input_.readInt32();
/*  903 */             int readTag = _input_.readTag();
/*  904 */             if (34 != readTag)
/*      */             {
/*  906 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  908 */             xbean.Property _v_ = xbean.Pod.newPropertyData();
/*  909 */             _input_.readMessage(_v_);
/*  910 */             this.partner2property.put(Integer.valueOf(_k_), _v_);
/*  911 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  915 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  917 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  926 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  930 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  932 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PartnerBag copy()
/*      */     {
/*  938 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PartnerBag toData()
/*      */     {
/*  944 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.PartnerBag toBean()
/*      */     {
/*  949 */       return new PartnerBag(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.PartnerBag toDataIf()
/*      */     {
/*  955 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.PartnerBag toBeanIf()
/*      */     {
/*  960 */       return new PartnerBag(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  966 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  970 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  974 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  978 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  982 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  986 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  990 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDefaultlineupnum()
/*      */     {
/*  997 */       return this.defaultlineupnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOwnpartnerids()
/*      */     {
/* 1004 */       return this.ownpartnerids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Integer> getOwnpartneridsAsData()
/*      */     {
/* 1011 */       return this.ownpartnerids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LineUp> getLineups()
/*      */     {
/* 1018 */       return this.lineups;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.LineUp> getLineupsAsData()
/*      */     {
/* 1025 */       return this.lineups;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Property> getPartner2property()
/*      */     {
/* 1032 */       return this.partner2property;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, xbean.Property> getPartner2propertyAsData()
/*      */     {
/* 1039 */       return this.partner2property;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDefaultlineupnum(int _v_)
/*      */     {
/* 1046 */       this.defaultlineupnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1052 */       if (!(_o1_ instanceof Data)) return false;
/* 1053 */       Data _o_ = (Data)_o1_;
/* 1054 */       if (this.defaultlineupnum != _o_.defaultlineupnum) return false;
/* 1055 */       if (!this.ownpartnerids.equals(_o_.ownpartnerids)) return false;
/* 1056 */       if (!this.lineups.equals(_o_.lineups)) return false;
/* 1057 */       if (!this.partner2property.equals(_o_.partner2property)) return false;
/* 1058 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1064 */       int _h_ = 0;
/* 1065 */       _h_ += this.defaultlineupnum;
/* 1066 */       _h_ += this.ownpartnerids.hashCode();
/* 1067 */       _h_ += this.lineups.hashCode();
/* 1068 */       _h_ += this.partner2property.hashCode();
/* 1069 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1075 */       StringBuilder _sb_ = new StringBuilder();
/* 1076 */       _sb_.append("(");
/* 1077 */       _sb_.append(this.defaultlineupnum);
/* 1078 */       _sb_.append(",");
/* 1079 */       _sb_.append(this.ownpartnerids);
/* 1080 */       _sb_.append(",");
/* 1081 */       _sb_.append(this.lineups);
/* 1082 */       _sb_.append(",");
/* 1083 */       _sb_.append(this.partner2property);
/* 1084 */       _sb_.append(")");
/* 1085 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PartnerBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */