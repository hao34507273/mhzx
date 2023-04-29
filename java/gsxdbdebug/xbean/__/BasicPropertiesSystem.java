/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ 
/*      */ public final class BasicPropertiesSystem extends XBean implements xbean.BasicPropertiesSystem
/*      */ {
/*      */   private int potentialpoint;
/*      */   private HashMap<Integer, Integer> basicpropertymap;
/*      */   private boolean isautospecialpoint;
/*      */   private HashMap<Integer, Integer> autoassignpointpref;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   24 */     this.potentialpoint = 0;
/*   25 */     this.basicpropertymap.clear();
/*   26 */     this.isautospecialpoint = false;
/*   27 */     this.autoassignpointpref.clear();
/*      */   }
/*      */   
/*      */   BasicPropertiesSystem(int __, XBean _xp_, String _vn_)
/*      */   {
/*   32 */     super(_xp_, _vn_);
/*   33 */     this.basicpropertymap = new HashMap();
/*   34 */     this.autoassignpointpref = new HashMap();
/*      */   }
/*      */   
/*      */   public BasicPropertiesSystem()
/*      */   {
/*   39 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BasicPropertiesSystem(BasicPropertiesSystem _o_)
/*      */   {
/*   44 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BasicPropertiesSystem(xbean.BasicPropertiesSystem _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   49 */     super(_xp_, _vn_);
/*   50 */     if ((_o1_ instanceof BasicPropertiesSystem)) { assign((BasicPropertiesSystem)_o1_);
/*   51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   53 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BasicPropertiesSystem _o_) {
/*   58 */     _o_._xdb_verify_unsafe_();
/*   59 */     this.potentialpoint = _o_.potentialpoint;
/*   60 */     this.basicpropertymap = new HashMap();
/*   61 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basicpropertymap.entrySet())
/*   62 */       this.basicpropertymap.put(_e_.getKey(), _e_.getValue());
/*   63 */     this.isautospecialpoint = _o_.isautospecialpoint;
/*   64 */     this.autoassignpointpref = new HashMap();
/*   65 */     for (Map.Entry<Integer, Integer> _e_ : _o_.autoassignpointpref.entrySet()) {
/*   66 */       this.autoassignpointpref.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Data _o_) {
/*   71 */     this.potentialpoint = _o_.potentialpoint;
/*   72 */     this.basicpropertymap = new HashMap();
/*   73 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basicpropertymap.entrySet())
/*   74 */       this.basicpropertymap.put(_e_.getKey(), _e_.getValue());
/*   75 */     this.isautospecialpoint = _o_.isautospecialpoint;
/*   76 */     this.autoassignpointpref = new HashMap();
/*   77 */     for (Map.Entry<Integer, Integer> _e_ : _o_.autoassignpointpref.entrySet()) {
/*   78 */       this.autoassignpointpref.put(_e_.getKey(), _e_.getValue());
/*      */     }
/*      */   }
/*      */   
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   84 */     _xdb_verify_unsafe_();
/*   85 */     _os_.marshal(this.potentialpoint);
/*   86 */     _os_.compact_uint32(this.basicpropertymap.size());
/*   87 */     for (Map.Entry<Integer, Integer> _e_ : this.basicpropertymap.entrySet())
/*      */     {
/*   89 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   90 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   92 */     _os_.marshal(this.isautospecialpoint);
/*   93 */     _os_.compact_uint32(this.autoassignpointpref.size());
/*   94 */     for (Map.Entry<Integer, Integer> _e_ : this.autoassignpointpref.entrySet())
/*      */     {
/*   96 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*   97 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*   99 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  105 */     _xdb_verify_unsafe_();
/*  106 */     this.potentialpoint = _os_.unmarshal_int();
/*      */     
/*  108 */     int size = _os_.uncompact_uint32();
/*  109 */     if (size >= 12)
/*      */     {
/*  111 */       this.basicpropertymap = new HashMap(size * 2);
/*      */     }
/*  113 */     for (; size > 0; size--)
/*      */     {
/*  115 */       int _k_ = 0;
/*  116 */       _k_ = _os_.unmarshal_int();
/*  117 */       int _v_ = 0;
/*  118 */       _v_ = _os_.unmarshal_int();
/*  119 */       this.basicpropertymap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  122 */     this.isautospecialpoint = _os_.unmarshal_boolean();
/*      */     
/*  124 */     int size = _os_.uncompact_uint32();
/*  125 */     if (size >= 12)
/*      */     {
/*  127 */       this.autoassignpointpref = new HashMap(size * 2);
/*      */     }
/*  129 */     for (; size > 0; size--)
/*      */     {
/*  131 */       int _k_ = 0;
/*  132 */       _k_ = _os_.unmarshal_int();
/*  133 */       int _v_ = 0;
/*  134 */       _v_ = _os_.unmarshal_int();
/*  135 */       this.autoassignpointpref.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  138 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  144 */     _xdb_verify_unsafe_();
/*  145 */     int _size_ = 0;
/*  146 */     _size_ += CodedOutputStream.computeInt32Size(1, this.potentialpoint);
/*  147 */     for (Map.Entry<Integer, Integer> _e_ : this.basicpropertymap.entrySet())
/*      */     {
/*  149 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  150 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  152 */     _size_ += CodedOutputStream.computeBoolSize(3, this.isautospecialpoint);
/*  153 */     for (Map.Entry<Integer, Integer> _e_ : this.autoassignpointpref.entrySet())
/*      */     {
/*  155 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  156 */       _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  158 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  167 */       _output_.writeInt32(1, this.potentialpoint);
/*  168 */       for (Map.Entry<Integer, Integer> _e_ : this.basicpropertymap.entrySet())
/*      */       {
/*  170 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  171 */         _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  173 */       _output_.writeBool(3, this.isautospecialpoint);
/*  174 */       for (Map.Entry<Integer, Integer> _e_ : this.autoassignpointpref.entrySet())
/*      */       {
/*  176 */         _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  177 */         _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  182 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  184 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  190 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  193 */       boolean done = false;
/*  194 */       while (!done)
/*      */       {
/*  196 */         int tag = _input_.readTag();
/*  197 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  201 */           done = true;
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  206 */           this.potentialpoint = _input_.readInt32();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  211 */           int _k_ = 0;
/*  212 */           _k_ = _input_.readInt32();
/*  213 */           int readTag = _input_.readTag();
/*  214 */           if (16 != readTag)
/*      */           {
/*  216 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  218 */           int _v_ = 0;
/*  219 */           _v_ = _input_.readInt32();
/*  220 */           this.basicpropertymap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  225 */           this.isautospecialpoint = _input_.readBool();
/*  226 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  230 */           int _k_ = 0;
/*  231 */           _k_ = _input_.readInt32();
/*  232 */           int readTag = _input_.readTag();
/*  233 */           if (32 != readTag)
/*      */           {
/*  235 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  237 */           int _v_ = 0;
/*  238 */           _v_ = _input_.readInt32();
/*  239 */           this.autoassignpointpref.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  240 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  244 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  246 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  255 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  259 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  261 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BasicPropertiesSystem copy()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new BasicPropertiesSystem(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BasicPropertiesSystem toData()
/*      */   {
/*  274 */     _xdb_verify_unsafe_();
/*  275 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BasicPropertiesSystem toBean()
/*      */   {
/*  280 */     _xdb_verify_unsafe_();
/*  281 */     return new BasicPropertiesSystem(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BasicPropertiesSystem toDataIf()
/*      */   {
/*  287 */     _xdb_verify_unsafe_();
/*  288 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BasicPropertiesSystem toBeanIf()
/*      */   {
/*  293 */     _xdb_verify_unsafe_();
/*  294 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  300 */     _xdb_verify_unsafe_();
/*  301 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPotentialpoint()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return this.potentialpoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBasicpropertymap()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return xdb.Logs.logMap(new LogKey(this, "basicpropertymap"), this.basicpropertymap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getBasicpropertymapAsData()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*      */     
/*  326 */     BasicPropertiesSystem _o_ = this;
/*  327 */     Map<Integer, Integer> basicpropertymap = new HashMap();
/*  328 */     for (Map.Entry<Integer, Integer> _e_ : _o_.basicpropertymap.entrySet())
/*  329 */       basicpropertymap.put(_e_.getKey(), _e_.getValue());
/*  330 */     return basicpropertymap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIsautospecialpoint()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return this.isautospecialpoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAutoassignpointpref()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return xdb.Logs.logMap(new LogKey(this, "autoassignpointpref"), this.autoassignpointpref);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getAutoassignpointprefAsData()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*      */     
/*  355 */     BasicPropertiesSystem _o_ = this;
/*  356 */     Map<Integer, Integer> autoassignpointpref = new HashMap();
/*  357 */     for (Map.Entry<Integer, Integer> _e_ : _o_.autoassignpointpref.entrySet())
/*  358 */       autoassignpointpref.put(_e_.getKey(), _e_.getValue());
/*  359 */     return autoassignpointpref;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPotentialpoint(int _v_)
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*  367 */     xdb.Logs.logIf(new LogKey(this, "potentialpoint")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  371 */         new xdb.logs.LogInt(this, BasicPropertiesSystem.this.potentialpoint)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  375 */             BasicPropertiesSystem.this.potentialpoint = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  379 */     });
/*  380 */     this.potentialpoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIsautospecialpoint(boolean _v_)
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     xdb.Logs.logIf(new LogKey(this, "isautospecialpoint")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  392 */         new xdb.logs.LogObject(this, Boolean.valueOf(BasicPropertiesSystem.this.isautospecialpoint))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  396 */             BasicPropertiesSystem.this.isautospecialpoint = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  400 */     });
/*  401 */     this.isautospecialpoint = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     BasicPropertiesSystem _o_ = null;
/*  409 */     if ((_o1_ instanceof BasicPropertiesSystem)) { _o_ = (BasicPropertiesSystem)_o1_;
/*  410 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  411 */       return false;
/*  412 */     if (this.potentialpoint != _o_.potentialpoint) return false;
/*  413 */     if (!this.basicpropertymap.equals(_o_.basicpropertymap)) return false;
/*  414 */     if (this.isautospecialpoint != _o_.isautospecialpoint) return false;
/*  415 */     if (!this.autoassignpointpref.equals(_o_.autoassignpointpref)) return false;
/*  416 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     int _h_ = 0;
/*  424 */     _h_ += this.potentialpoint;
/*  425 */     _h_ += this.basicpropertymap.hashCode();
/*  426 */     _h_ += (this.isautospecialpoint ? 1231 : 1237);
/*  427 */     _h_ += this.autoassignpointpref.hashCode();
/*  428 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  434 */     _xdb_verify_unsafe_();
/*  435 */     StringBuilder _sb_ = new StringBuilder();
/*  436 */     _sb_.append("(");
/*  437 */     _sb_.append(this.potentialpoint);
/*  438 */     _sb_.append(",");
/*  439 */     _sb_.append(this.basicpropertymap);
/*  440 */     _sb_.append(",");
/*  441 */     _sb_.append(this.isautospecialpoint);
/*  442 */     _sb_.append(",");
/*  443 */     _sb_.append(this.autoassignpointpref);
/*  444 */     _sb_.append(")");
/*  445 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  451 */     ListenableBean lb = new ListenableBean();
/*  452 */     lb.add(new xdb.logs.ListenableChanged().setVarName("potentialpoint"));
/*  453 */     lb.add(new xdb.logs.ListenableMap().setVarName("basicpropertymap"));
/*  454 */     lb.add(new xdb.logs.ListenableChanged().setVarName("isautospecialpoint"));
/*  455 */     lb.add(new xdb.logs.ListenableMap().setVarName("autoassignpointpref"));
/*  456 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BasicPropertiesSystem {
/*      */     private Const() {}
/*      */     
/*      */     BasicPropertiesSystem nThis() {
/*  463 */       return BasicPropertiesSystem.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  469 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BasicPropertiesSystem copy()
/*      */     {
/*  475 */       return BasicPropertiesSystem.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BasicPropertiesSystem toData()
/*      */     {
/*  481 */       return BasicPropertiesSystem.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BasicPropertiesSystem toBean()
/*      */     {
/*  486 */       return BasicPropertiesSystem.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BasicPropertiesSystem toDataIf()
/*      */     {
/*  492 */       return BasicPropertiesSystem.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BasicPropertiesSystem toBeanIf()
/*      */     {
/*  497 */       return BasicPropertiesSystem.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPotentialpoint()
/*      */     {
/*  504 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  505 */       return BasicPropertiesSystem.this.potentialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasicpropertymap()
/*      */     {
/*  512 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  513 */       return xdb.Consts.constMap(BasicPropertiesSystem.this.basicpropertymap);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasicpropertymapAsData()
/*      */     {
/*  520 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*      */       
/*  522 */       BasicPropertiesSystem _o_ = BasicPropertiesSystem.this;
/*  523 */       Map<Integer, Integer> basicpropertymap = new HashMap();
/*  524 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basicpropertymap.entrySet())
/*  525 */         basicpropertymap.put(_e_.getKey(), _e_.getValue());
/*  526 */       return basicpropertymap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsautospecialpoint()
/*      */     {
/*  533 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  534 */       return BasicPropertiesSystem.this.isautospecialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAutoassignpointpref()
/*      */     {
/*  541 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  542 */       return xdb.Consts.constMap(BasicPropertiesSystem.this.autoassignpointpref);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAutoassignpointprefAsData()
/*      */     {
/*  549 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*      */       
/*  551 */       BasicPropertiesSystem _o_ = BasicPropertiesSystem.this;
/*  552 */       Map<Integer, Integer> autoassignpointpref = new HashMap();
/*  553 */       for (Map.Entry<Integer, Integer> _e_ : _o_.autoassignpointpref.entrySet())
/*  554 */         autoassignpointpref.put(_e_.getKey(), _e_.getValue());
/*  555 */       return autoassignpointpref;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPotentialpoint(int _v_)
/*      */     {
/*  562 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  563 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsautospecialpoint(boolean _v_)
/*      */     {
/*  570 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  571 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  577 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  578 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  584 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  585 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  591 */       return BasicPropertiesSystem.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  597 */       return BasicPropertiesSystem.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  603 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  604 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  610 */       return BasicPropertiesSystem.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  616 */       return BasicPropertiesSystem.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  622 */       BasicPropertiesSystem.this._xdb_verify_unsafe_();
/*  623 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  629 */       return BasicPropertiesSystem.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  635 */       return BasicPropertiesSystem.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  641 */       return BasicPropertiesSystem.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  647 */       return BasicPropertiesSystem.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  653 */       return BasicPropertiesSystem.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  659 */       return BasicPropertiesSystem.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  665 */       return BasicPropertiesSystem.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BasicPropertiesSystem
/*      */   {
/*      */     private int potentialpoint;
/*      */     
/*      */     private HashMap<Integer, Integer> basicpropertymap;
/*      */     
/*      */     private boolean isautospecialpoint;
/*      */     
/*      */     private HashMap<Integer, Integer> autoassignpointpref;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  683 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  688 */       this.basicpropertymap = new HashMap();
/*  689 */       this.autoassignpointpref = new HashMap();
/*      */     }
/*      */     
/*      */     Data(xbean.BasicPropertiesSystem _o1_)
/*      */     {
/*  694 */       if ((_o1_ instanceof BasicPropertiesSystem)) { assign((BasicPropertiesSystem)_o1_);
/*  695 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  696 */       } else if ((_o1_ instanceof BasicPropertiesSystem.Const)) assign(((BasicPropertiesSystem.Const)_o1_).nThis()); else {
/*  697 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BasicPropertiesSystem _o_) {
/*  702 */       this.potentialpoint = _o_.potentialpoint;
/*  703 */       this.basicpropertymap = new HashMap();
/*  704 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basicpropertymap.entrySet())
/*  705 */         this.basicpropertymap.put(_e_.getKey(), _e_.getValue());
/*  706 */       this.isautospecialpoint = _o_.isautospecialpoint;
/*  707 */       this.autoassignpointpref = new HashMap();
/*  708 */       for (Map.Entry<Integer, Integer> _e_ : _o_.autoassignpointpref.entrySet()) {
/*  709 */         this.autoassignpointpref.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Data _o_) {
/*  714 */       this.potentialpoint = _o_.potentialpoint;
/*  715 */       this.basicpropertymap = new HashMap();
/*  716 */       for (Map.Entry<Integer, Integer> _e_ : _o_.basicpropertymap.entrySet())
/*  717 */         this.basicpropertymap.put(_e_.getKey(), _e_.getValue());
/*  718 */       this.isautospecialpoint = _o_.isautospecialpoint;
/*  719 */       this.autoassignpointpref = new HashMap();
/*  720 */       for (Map.Entry<Integer, Integer> _e_ : _o_.autoassignpointpref.entrySet()) {
/*  721 */         this.autoassignpointpref.put(_e_.getKey(), _e_.getValue());
/*      */       }
/*      */     }
/*      */     
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  727 */       _os_.marshal(this.potentialpoint);
/*  728 */       _os_.compact_uint32(this.basicpropertymap.size());
/*  729 */       for (Map.Entry<Integer, Integer> _e_ : this.basicpropertymap.entrySet())
/*      */       {
/*  731 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  732 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  734 */       _os_.marshal(this.isautospecialpoint);
/*  735 */       _os_.compact_uint32(this.autoassignpointpref.size());
/*  736 */       for (Map.Entry<Integer, Integer> _e_ : this.autoassignpointpref.entrySet())
/*      */       {
/*  738 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  739 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/*  741 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  747 */       this.potentialpoint = _os_.unmarshal_int();
/*      */       
/*  749 */       int size = _os_.uncompact_uint32();
/*  750 */       if (size >= 12)
/*      */       {
/*  752 */         this.basicpropertymap = new HashMap(size * 2);
/*      */       }
/*  754 */       for (; size > 0; size--)
/*      */       {
/*  756 */         int _k_ = 0;
/*  757 */         _k_ = _os_.unmarshal_int();
/*  758 */         int _v_ = 0;
/*  759 */         _v_ = _os_.unmarshal_int();
/*  760 */         this.basicpropertymap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  763 */       this.isautospecialpoint = _os_.unmarshal_boolean();
/*      */       
/*  765 */       int size = _os_.uncompact_uint32();
/*  766 */       if (size >= 12)
/*      */       {
/*  768 */         this.autoassignpointpref = new HashMap(size * 2);
/*      */       }
/*  770 */       for (; size > 0; size--)
/*      */       {
/*  772 */         int _k_ = 0;
/*  773 */         _k_ = _os_.unmarshal_int();
/*  774 */         int _v_ = 0;
/*  775 */         _v_ = _os_.unmarshal_int();
/*  776 */         this.autoassignpointpref.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/*  779 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  785 */       int _size_ = 0;
/*  786 */       _size_ += CodedOutputStream.computeInt32Size(1, this.potentialpoint);
/*  787 */       for (Map.Entry<Integer, Integer> _e_ : this.basicpropertymap.entrySet())
/*      */       {
/*  789 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*  790 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  792 */       _size_ += CodedOutputStream.computeBoolSize(3, this.isautospecialpoint);
/*  793 */       for (Map.Entry<Integer, Integer> _e_ : this.autoassignpointpref.entrySet())
/*      */       {
/*  795 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getKey()).intValue());
/*  796 */         _size_ += CodedOutputStream.computeInt32Size(4, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  798 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  806 */         _output_.writeInt32(1, this.potentialpoint);
/*  807 */         for (Map.Entry<Integer, Integer> _e_ : this.basicpropertymap.entrySet())
/*      */         {
/*  809 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/*  810 */           _output_.writeInt32(2, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*  812 */         _output_.writeBool(3, this.isautospecialpoint);
/*  813 */         for (Map.Entry<Integer, Integer> _e_ : this.autoassignpointpref.entrySet())
/*      */         {
/*  815 */           _output_.writeInt32(4, ((Integer)_e_.getKey()).intValue());
/*  816 */           _output_.writeInt32(4, ((Integer)_e_.getValue()).intValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  821 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  823 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  831 */         boolean done = false;
/*  832 */         while (!done)
/*      */         {
/*  834 */           int tag = _input_.readTag();
/*  835 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  839 */             done = true;
/*  840 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  844 */             this.potentialpoint = _input_.readInt32();
/*  845 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  849 */             int _k_ = 0;
/*  850 */             _k_ = _input_.readInt32();
/*  851 */             int readTag = _input_.readTag();
/*  852 */             if (16 != readTag)
/*      */             {
/*  854 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  856 */             int _v_ = 0;
/*  857 */             _v_ = _input_.readInt32();
/*  858 */             this.basicpropertymap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  859 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  863 */             this.isautospecialpoint = _input_.readBool();
/*  864 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  868 */             int _k_ = 0;
/*  869 */             _k_ = _input_.readInt32();
/*  870 */             int readTag = _input_.readTag();
/*  871 */             if (32 != readTag)
/*      */             {
/*  873 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/*  875 */             int _v_ = 0;
/*  876 */             _v_ = _input_.readInt32();
/*  877 */             this.autoassignpointpref.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*  878 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  882 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  884 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  893 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  897 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  899 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BasicPropertiesSystem copy()
/*      */     {
/*  905 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BasicPropertiesSystem toData()
/*      */     {
/*  911 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BasicPropertiesSystem toBean()
/*      */     {
/*  916 */       return new BasicPropertiesSystem(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BasicPropertiesSystem toDataIf()
/*      */     {
/*  922 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BasicPropertiesSystem toBeanIf()
/*      */     {
/*  927 */       return new BasicPropertiesSystem(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  933 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/*  937 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/*  949 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  953 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  957 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPotentialpoint()
/*      */     {
/*  964 */       return this.potentialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasicpropertymap()
/*      */     {
/*  971 */       return this.basicpropertymap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getBasicpropertymapAsData()
/*      */     {
/*  978 */       return this.basicpropertymap;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIsautospecialpoint()
/*      */     {
/*  985 */       return this.isautospecialpoint;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAutoassignpointpref()
/*      */     {
/*  992 */       return this.autoassignpointpref;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Integer, Integer> getAutoassignpointprefAsData()
/*      */     {
/*  999 */       return this.autoassignpointpref;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPotentialpoint(int _v_)
/*      */     {
/* 1006 */       this.potentialpoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIsautospecialpoint(boolean _v_)
/*      */     {
/* 1013 */       this.isautospecialpoint = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1019 */       if (!(_o1_ instanceof Data)) return false;
/* 1020 */       Data _o_ = (Data)_o1_;
/* 1021 */       if (this.potentialpoint != _o_.potentialpoint) return false;
/* 1022 */       if (!this.basicpropertymap.equals(_o_.basicpropertymap)) return false;
/* 1023 */       if (this.isautospecialpoint != _o_.isautospecialpoint) return false;
/* 1024 */       if (!this.autoassignpointpref.equals(_o_.autoassignpointpref)) return false;
/* 1025 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1031 */       int _h_ = 0;
/* 1032 */       _h_ += this.potentialpoint;
/* 1033 */       _h_ += this.basicpropertymap.hashCode();
/* 1034 */       _h_ += (this.isautospecialpoint ? 1231 : 1237);
/* 1035 */       _h_ += this.autoassignpointpref.hashCode();
/* 1036 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1042 */       StringBuilder _sb_ = new StringBuilder();
/* 1043 */       _sb_.append("(");
/* 1044 */       _sb_.append(this.potentialpoint);
/* 1045 */       _sb_.append(",");
/* 1046 */       _sb_.append(this.basicpropertymap);
/* 1047 */       _sb_.append(",");
/* 1048 */       _sb_.append(this.isautospecialpoint);
/* 1049 */       _sb_.append(",");
/* 1050 */       _sb_.append(this.autoassignpointpref);
/* 1051 */       _sb_.append(")");
/* 1052 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BasicPropertiesSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */